package com.tencent.biz.pubaccount.weishi_new.net.common;

import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import UserGrowth.stCompressedData;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.UniAttributeW;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.now.netchannel.tool.GZipUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.WNSStream;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.WnsError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class WSResponseDecoder
{
  @NotNull
  private static <T extends JceStruct> RspHeaderBean a(WSRequest<T> paramWSRequest, QmfDownstream paramQmfDownstream)
  {
    paramQmfDownstream = (stRspHeader)a(paramQmfDownstream.BusiBuff, "stRspHeader", new stRspHeader());
    RspHeaderBean localRspHeaderBean = new RspHeaderBean();
    if ((paramQmfDownstream != null) && (paramQmfDownstream.mapExt != null))
    {
      localRspHeaderBean.jdField_a_of_type_JavaUtilMap = paramQmfDownstream.mapExt;
      Object localObject = paramQmfDownstream.mapExt;
      int i = paramWSRequest.getRequestScene();
      WSLog.a("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]pageType scene：" + i);
      WSRequest.pageTypeExtMap.put(Integer.valueOf(i), localObject);
      if (WSNetUtil.a())
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          WSLog.a("[WSService]", paramWSRequest.getRspUinKey() + " 存进去 》》》 key:" + (String)localEntry.getKey() + ", value:" + (String)localEntry.getValue());
        }
      }
      localObject = (String)paramQmfDownstream.mapExt.get("qq_abtest");
      WSLog.a("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {iRet:" + paramQmfDownstream.iRet + ", sErrMsg:" + paramQmfDownstream.sErrmsg + ", scene:" + i + ", abTestId:" + (String)localObject + "}");
      if ("SimpleGetFeedList".equals(paramWSRequest.getOnlyCmd())) {
        LocalMultiProcConfig.putString4Uin("key_default_test_id", (String)localObject, WeishiUtils.a());
      }
      localRspHeaderBean.jdField_a_of_type_JavaLangString = ((String)localObject);
      WSReportUtils.a(i, (String)localObject);
      localObject = (String)paramQmfDownstream.mapExt.get("person_id");
      WSLog.b("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {personId:" + (String)localObject + "}");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        WeishiUtils.b((String)localObject);
      }
      if ((paramQmfDownstream.iRet == -99) && (paramWSRequest.isShouldStartQQAuth())) {
        WSQQConnectAuthManager.a().b();
      }
    }
    paramWSRequest.getTimeRecord().h();
    return localRspHeaderBean;
  }
  
  private static <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      WSLog.d("[WSService]", paramArrayOfByte.getLocalizedMessage());
    }
    return null;
  }
  
  private static <T extends JceStruct> void a(WSRequest<T> paramWSRequest, UniAttributeW paramUniAttributeW)
  {
    paramUniAttributeW = (QmfServerInfo)paramUniAttributeW.get("server_info");
    if (WebAppIpManager.isValidServerInfo(paramUniAttributeW))
    {
      WebAppIpManager.getInstance().addWebAppIpRecord(paramUniAttributeW);
      paramWSRequest.params.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(paramUniAttributeW.ipWebapp.ClientIpv4));
    }
  }
  
  public static <T extends JceStruct> void a(WSRequest<T> paramWSRequest, byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg, @NotNull WSResponseDecoder.DecodeCallback<T> paramDecodeCallback)
  {
    String str = paramWSRequest.getReqUniKey();
    if (paramArrayOfByte == null)
    {
      WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + str + ", decodeAndCallback() data is null");
      paramDecodeCallback.decodeFailure(null, 1000003, "data is null");
      return;
    }
    UniAttributeW localUniAttributeW;
    try
    {
      paramArrayOfByte = new WNSStream().unpack(paramArrayOfByte);
      paramWSRequest.getTimeRecord().f();
      localUniAttributeW = new UniAttributeW();
      if (paramArrayOfByte == null)
      {
        WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd=" + str + " WSRequest unpack error,result is null");
        paramDecodeCallback.decodeFailure(localUniAttributeW, 1000003, "unpack error");
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte = WSLog.a(paramArrayOfByte);
      paramWSRequest.addParameter("key_report_detail_msg", paramArrayOfByte);
      WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + str + ", occur exception. stack info:" + paramArrayOfByte);
      paramDecodeCallback.decodeFailure(null, 1000001, "decodeAndCallback occur exception");
      return;
    }
    if (paramArrayOfByte.WnsCode != 0)
    {
      WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + str + ", wnsCode:" + paramArrayOfByte.WnsCode + ", msg:" + WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
      paramDecodeCallback.decodeFailure(localUniAttributeW, paramArrayOfByte.WnsCode, WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
      return;
    }
    localUniAttributeW.setEncodeName("utf-8");
    localUniAttributeW.decode(paramArrayOfByte.Extra);
    a(paramWSRequest, localUniAttributeW);
    if (!a(paramArrayOfByte, localUniAttributeW))
    {
      WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd=" + str + " WSRequest decompress error");
      paramDecodeCallback.decodeFailure(localUniAttributeW, 1000002, "decompress error");
      return;
    }
    paramWSRequest.getTimeRecord().g();
    RspHeaderBean localRspHeaderBean = a(paramWSRequest, paramArrayOfByte);
    if (a(localRspHeaderBean))
    {
      paramArrayOfByte = a(paramWSRequest, paramArrayOfByte.BusiBuff);
      if (paramArrayOfByte == null) {}
    }
    int i;
    for (paramArrayOfByte = JceUtils.decodeWup(paramWSRequest.getRspClass(), paramArrayOfByte);; paramArrayOfByte = (JceStruct)a(paramArrayOfByte.BusiBuff, paramWSRequest.getRspUinKey(), paramWSRequest.getRspClass().newInstance()))
    {
      paramWSRequest.getTimeRecord().k();
      i = paramFromServiceMsg.getResultCode();
      if (paramArrayOfByte != null) {
        break;
      }
      WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback] decode rsp failure!!");
      paramDecodeCallback.decodeFailure(localUniAttributeW, i, "decode failure");
      return;
      paramDecodeCallback.decodeFailure(localUniAttributeW, 2000003, "rsp gzip decompress error");
      return;
    }
    if (a(i))
    {
      paramDecodeCallback.decodeSuccess(paramArrayOfByte, i, paramFromServiceMsg.getBusinessFailMsg(), localRspHeaderBean);
      return;
    }
    paramDecodeCallback.decodeFailure(localUniAttributeW, i, "");
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1000) || ((Math.abs(paramInt) <= 19999) && (Math.abs(paramInt) >= 19000));
  }
  
  private static boolean a(QmfDownstream paramQmfDownstream, UniAttributeW paramUniAttributeW)
  {
    paramUniAttributeW = (QmfBusiControl)paramUniAttributeW.get("busiCompCtl");
    if ((paramUniAttributeW != null) && (1 == paramUniAttributeW.compFlag))
    {
      paramUniAttributeW = WNSStream.decompress(paramQmfDownstream.BusiBuff);
      if (paramUniAttributeW != null) {
        paramQmfDownstream.BusiBuff = paramUniAttributeW;
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  private static boolean a(RspHeaderBean paramRspHeaderBean)
  {
    if ((paramRspHeaderBean == null) || (paramRspHeaderBean.jdField_a_of_type_JavaUtilMap == null))
    {
      WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
      return false;
    }
    if (!paramRspHeaderBean.jdField_a_of_type_JavaUtilMap.containsKey("qq_compressed"))
    {
      WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
      return false;
    }
    return true;
  }
  
  private static <T extends JceStruct> byte[] a(WSRequest<T> paramWSRequest, byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    paramWSRequest.setGzipCompress(true);
    paramArrayOfByte = (stCompressedData)a(paramArrayOfByte, "stCompressedData", new stCompressedData());
    paramWSRequest.getTimeRecord().i();
    if (paramArrayOfByte == null)
    {
      WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
      return null;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = paramArrayOfByte.compressed;
        i = paramArrayOfByte.length;
        paramArrayOfByte = GZipUtil.a(paramArrayOfByte);
        int j;
        Object localObject;
        WSLog.d("[WSService]", "[WSResponseDecoder.java][checkRspCompress] exception:" + paramArrayOfByte.getLocalizedMessage());
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          j = paramArrayOfByte.length;
          localObject = Arrays.copyOfRange(paramArrayOfByte, 1, j);
          paramArrayOfByte = (byte[])localObject;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            int i;
            paramWSRequest = paramArrayOfByte;
            paramArrayOfByte = localException1;
          }
        }
        try
        {
          localObject = paramWSRequest.getCompressInfo();
          ((WSGzipCompressInfo)localObject).a(i);
          ((WSGzipCompressInfo)localObject).b(j);
          ((WSGzipCompressInfo)localObject).a(i / j);
          paramWSRequest.getTimeRecord().j();
          paramWSRequest = paramArrayOfByte;
          paramArrayOfByte = new StringBuilder().append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
          if (paramWSRequest == null) {
            break label200;
          }
          i = paramWSRequest.length;
          WSLog.e("[WSService]", i + ", cost:" + (System.currentTimeMillis() - l));
          return paramWSRequest;
        }
        catch (Exception localException2)
        {
          paramWSRequest = paramArrayOfByte;
          paramArrayOfByte = localException2;
          break label169;
        }
        paramArrayOfByte = paramArrayOfByte;
        paramWSRequest = null;
      }
      label169:
      continue;
      label200:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSResponseDecoder
 * JD-Core Version:    0.7.0.1
 */