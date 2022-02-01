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
import com.tencent.biz.pubaccount.weishi_new.util.GZipUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
      Object localObject1 = paramQmfDownstream.mapExt;
      int i = paramWSRequest.getRequestScene();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[WSResponseDecoder.java][decodeAndCallback]pageType scene：");
      ((StringBuilder)localObject2).append(i);
      WSLog.a("[WSService]", ((StringBuilder)localObject2).toString());
      WSRequest.pageTypeExtMap.put(Integer.valueOf(i), localObject1);
      if (WSNetUtil.a())
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramWSRequest.getRspUinKey());
          localStringBuilder.append(" 存进去 》》》 key:");
          localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
          localStringBuilder.append(", value:");
          localStringBuilder.append((String)((Map.Entry)localObject2).getValue());
          WSLog.a("[WSService]", localStringBuilder.toString());
        }
      }
      localObject1 = (String)paramQmfDownstream.mapExt.get("qq_abtest");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {iRet:");
      ((StringBuilder)localObject2).append(paramQmfDownstream.iRet);
      ((StringBuilder)localObject2).append(", sErrMsg:");
      ((StringBuilder)localObject2).append(paramQmfDownstream.sErrmsg);
      ((StringBuilder)localObject2).append(", scene:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", abTestId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("}");
      WSLog.a("[WSService]", ((StringBuilder)localObject2).toString());
      if ("SimpleGetFeedList".equals(paramWSRequest.getOnlyCmd())) {
        LocalMultiProcConfig.putString4Uin("key_default_test_id", (String)localObject1, WeishiUtils.a());
      }
      localRspHeaderBean.jdField_a_of_type_JavaLangString = ((String)localObject1);
      WSReportUtils.a(i, (String)localObject1);
      localObject1 = (String)paramQmfDownstream.mapExt.get("person_id");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {personId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("}");
      WSLog.b("[WSService]", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        WeishiUtils.b((String)localObject1);
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
      paramWSRequest = new StringBuilder();
      paramWSRequest.append("[WSResponseDecoder.java][decodeAndCallback]cmd:");
      paramWSRequest.append(str);
      paramWSRequest.append(", decodeAndCallback() data is null");
      WSLog.d("[WSService]", paramWSRequest.toString());
      paramDecodeCallback.decodeFailure(null, 1000003, "data is null");
      return;
    }
    try
    {
      paramArrayOfByte = new WNSStream().unpack(paramArrayOfByte);
      paramWSRequest.getTimeRecord().f();
      UniAttributeW localUniAttributeW = new UniAttributeW();
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("[WSResponseDecoder.java][decodeAndCallback]cmd=");
        paramArrayOfByte.append(str);
        paramArrayOfByte.append(" WSRequest unpack error,result is null");
        WSLog.d("[WSService]", paramArrayOfByte.toString());
        paramDecodeCallback.decodeFailure(localUniAttributeW, 1000003, "unpack error");
        return;
      }
      if (paramArrayOfByte.WnsCode != 0)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[WSResponseDecoder.java][decodeAndCallback]cmd:");
        paramFromServiceMsg.append(str);
        paramFromServiceMsg.append(", wnsCode:");
        paramFromServiceMsg.append(paramArrayOfByte.WnsCode);
        paramFromServiceMsg.append(", msg:");
        paramFromServiceMsg.append(WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
        WSLog.d("[WSService]", paramFromServiceMsg.toString());
        paramDecodeCallback.decodeFailure(localUniAttributeW, paramArrayOfByte.WnsCode, WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
        return;
      }
      localUniAttributeW.setEncodeName("utf-8");
      localUniAttributeW.decode(paramArrayOfByte.Extra);
      a(paramWSRequest, localUniAttributeW);
      if (!a(paramArrayOfByte, localUniAttributeW))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("[WSResponseDecoder.java][decodeAndCallback]cmd=");
        paramArrayOfByte.append(str);
        paramArrayOfByte.append(" WSRequest decompress error");
        WSLog.d("[WSService]", paramArrayOfByte.toString());
        paramDecodeCallback.decodeFailure(localUniAttributeW, 1000002, "decompress error");
        return;
      }
      paramWSRequest.getTimeRecord().g();
      RspHeaderBean localRspHeaderBean = a(paramWSRequest, paramArrayOfByte);
      if (a(localRspHeaderBean))
      {
        paramArrayOfByte = a(paramWSRequest, paramArrayOfByte.BusiBuff);
        if (paramArrayOfByte != null) {
          paramArrayOfByte = JceUtils.decodeWup(paramWSRequest.getRspClass(), paramArrayOfByte);
        } else {
          paramDecodeCallback.decodeFailure(localUniAttributeW, 2000003, "rsp gzip decompress error");
        }
      }
      else
      {
        paramArrayOfByte = (JceStruct)a(paramArrayOfByte.BusiBuff, paramWSRequest.getRspUinKey(), paramWSRequest.getRspClass().newInstance());
      }
      paramWSRequest.getTimeRecord().k();
      int i = paramFromServiceMsg.getResultCode();
      if (paramArrayOfByte == null)
      {
        WSLog.d("[WSService]", "[WSResponseDecoder.java][decodeAndCallback] decode rsp failure!!");
        paramDecodeCallback.decodeFailure(localUniAttributeW, i, "decode failure");
        return;
      }
      if (a(i))
      {
        paramDecodeCallback.decodeSuccess(paramArrayOfByte, i, paramFromServiceMsg.getBusinessFailMsg(), localRspHeaderBean);
        return;
      }
      paramDecodeCallback.decodeFailure(localUniAttributeW, i, "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte = WSLog.a(paramArrayOfByte);
      paramWSRequest.addParameter("key_report_detail_msg", paramArrayOfByte);
      paramWSRequest = new StringBuilder();
      paramWSRequest.append("[WSResponseDecoder.java][decodeAndCallback]cmd:");
      paramWSRequest.append(str);
      paramWSRequest.append(", occur exception. stack info:");
      paramWSRequest.append(paramArrayOfByte);
      WSLog.d("[WSService]", paramWSRequest.toString());
      paramDecodeCallback.decodeFailure(null, 1000001, "decodeAndCallback occur exception");
    }
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
      if (paramUniAttributeW != null)
      {
        paramQmfDownstream.BusiBuff = paramUniAttributeW;
        return true;
      }
      return false;
    }
    return true;
  }
  
  private static boolean a(RspHeaderBean paramRspHeaderBean)
  {
    if ((paramRspHeaderBean != null) && (paramRspHeaderBean.jdField_a_of_type_JavaUtilMap != null))
    {
      if (!paramRspHeaderBean.jdField_a_of_type_JavaUtilMap.containsKey("qq_compressed"))
      {
        WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
        return false;
      }
      return true;
    }
    WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
    return false;
  }
  
  private static <T extends JceStruct> byte[] a(WSRequest<T> paramWSRequest, byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    paramWSRequest.setGzipCompress(true);
    Object localObject2 = (stCompressedData)a(paramArrayOfByte, "stCompressedData", new stCompressedData());
    paramWSRequest.getTimeRecord().i();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      WSLog.e("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
      return null;
    }
    paramArrayOfByte = (byte[])localObject1;
    int i;
    try
    {
      localObject2 = ((stCompressedData)localObject2).compressed;
      paramArrayOfByte = (byte[])localObject1;
      i = localObject2.length;
      paramArrayOfByte = (byte[])localObject1;
      localObject1 = GZipUtil.a((byte[])localObject2);
      paramArrayOfByte = (byte[])localObject1;
      int j = localObject1.length;
      paramArrayOfByte = (byte[])localObject1;
      localObject1 = Arrays.copyOfRange((byte[])localObject1, 1, j);
      paramArrayOfByte = (byte[])localObject1;
      localObject2 = paramWSRequest.getCompressInfo();
      paramArrayOfByte = (byte[])localObject1;
      ((WSGzipCompressInfo)localObject2).a(i);
      paramArrayOfByte = (byte[])localObject1;
      ((WSGzipCompressInfo)localObject2).b(j);
      paramArrayOfByte = (byte[])localObject1;
      ((WSGzipCompressInfo)localObject2).a(i / j);
      paramArrayOfByte = (byte[])localObject1;
      paramWSRequest.getTimeRecord().j();
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (Exception paramWSRequest)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSResponseDecoder.java][checkRspCompress] exception:");
      ((StringBuilder)localObject1).append(paramWSRequest.getLocalizedMessage());
      WSLog.d("[WSService]", ((StringBuilder)localObject1).toString());
    }
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = 0;
    }
    paramWSRequest.append(i);
    paramWSRequest.append(", cost:");
    paramWSRequest.append(System.currentTimeMillis() - l);
    WSLog.e("[WSService]", paramWSRequest.toString());
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSResponseDecoder
 * JD-Core Version:    0.7.0.1
 */