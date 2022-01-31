import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.cs.cmd0xe07.cmd0xe07.Coordinate;
import tencent.im.cs.cmd0xe07.cmd0xe07.Language;
import tencent.im.cs.cmd0xe07.cmd0xe07.OCRReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.OCRRspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.Polygon;
import tencent.im.cs.cmd0xe07.cmd0xe07.ReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.RspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07.TextDetection;

public class aqmt
  extends ajtd
{
  public aqmt(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    return 2;
  }
  
  public void a(aqmx paramaqmx)
  {
    a(paramaqmx.f, paramaqmx.jdField_b_of_type_Long, paramaqmx.jdField_d_of_type_JavaLangString, paramaqmx.e, paramaqmx.jdField_a_of_type_Int, (int)paramaqmx.jdField_a_of_type_Long, paramaqmx.jdField_b_of_type_Int, paramaqmx.jdField_c_of_type_Int, paramaqmx.jdField_a_of_type_Boolean, paramaqmx.jdField_a_of_type_JavaLangString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    long l;
    String str1;
    String str2;
    int i2;
    int i3;
    int i4;
    String str3;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    aqnb localaqnb;
    HashMap localHashMap;
    Object localObject1;
    Object localObject2;
    int k;
    int i1;
    Object localObject3;
    int i;
    label222:
    int n;
    int m;
    int j;
    Object localObject5;
    Object localObject4;
    label606:
    Object localObject6;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      l = ((Long)paramToServiceMsg.getAttribute("key_ocr_seq", Long.valueOf(0L))).longValue();
      str1 = (String)paramToServiceMsg.getAttribute("key_ocr_md5", "");
      str2 = (String)paramToServiceMsg.getAttribute("key_ocr_url", "");
      i2 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_size", Integer.valueOf(0))).intValue();
      i3 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_width", Integer.valueOf(0))).intValue();
      i4 = ((Integer)paramToServiceMsg.getAttribute("key_ocr_height", Integer.valueOf(0))).intValue();
      str3 = (String)paramToServiceMsg.getAttribute("key_ocr_afmd5", "");
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localaqnb = new aqnb();
      localHashMap = new HashMap();
      localObject1 = null;
      localObject2 = null;
      k = -1;
      i1 = -1;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localObject3 = new cmd0xe07.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool2;
          k = -1;
          paramFromServiceMsg = null;
          localObject1 = null;
          i = -1;
          j = -1;
          paramToServiceMsg = null;
          paramObject = null;
        }
      }
      try
      {
        paramToServiceMsg = ((cmd0xe07.RspBody)localObject3).errMsg.get();
      }
      catch (Exception localException3)
      {
        j = -1;
        paramToServiceMsg = null;
        paramObject = null;
        paramFromServiceMsg = null;
        localObject1 = null;
        k = -1;
        break label606;
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = ((cmd0xe07.RspBody)localObject3).wording.get();
          if (i == 0)
          {
            bool1 = true;
            if (!bool1) {
              continue;
            }
          }
        }
        catch (Exception localException4)
        {
          j = -1;
          paramFromServiceMsg = null;
          paramObject = paramToServiceMsg;
          localObject3 = null;
          localObject1 = null;
          k = -1;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)localObject3;
          break label606;
          n = -1;
          i1 = -1;
          localObject3 = null;
          localObject6 = null;
          m = i;
          localObject4 = paramFromServiceMsg;
          localObject5 = paramToServiceMsg;
          break label706;
        }
        try
        {
          if (!((cmd0xe07.RspBody)localObject3).ocrRspBody.has()) {
            continue;
          }
          localObject3 = (cmd0xe07.OCRRspBody)((cmd0xe07.RspBody)localObject3).ocrRspBody.get();
          paramObject = localObject2;
          if (((cmd0xe07.OCRRspBody)localObject3).requestId.has()) {
            paramObject = ((cmd0xe07.OCRRspBody)localObject3).requestId.get();
          }
        }
        catch (Exception localException5)
        {
          j = -1;
          localObject3 = null;
          paramObject = paramToServiceMsg;
          localObject1 = null;
          k = -1;
          paramToServiceMsg = (ToServiceMsg)localObject3;
          break label606;
        }
      }
      try
      {
        if (((cmd0xe07.OCRRspBody)localObject3).language.has()) {
          localObject1 = ((cmd0xe07.OCRRspBody)localObject3).language.get();
        }
        n = i1;
        m = k;
        try
        {
          if (((cmd0xe07.OCRRspBody)localObject3).ocrLanguageList.has())
          {
            n = i1;
            m = k;
            localArrayList2.addAll(((cmd0xe07.OCRRspBody)localObject3).ocrLanguageList.get());
          }
          j = k;
          n = i1;
          m = k;
          if (((cmd0xe07.OCRRspBody)localObject3).afterCompressWeight.has())
          {
            n = i1;
            m = k;
            j = ((cmd0xe07.OCRRspBody)localObject3).afterCompressWeight.get();
          }
          k = i1;
          n = i1;
          m = j;
          if (((cmd0xe07.OCRRspBody)localObject3).afterCompressHeight.has())
          {
            n = i1;
            m = j;
            k = ((cmd0xe07.OCRRspBody)localObject3).afterCompressHeight.get();
          }
          n = k;
          m = j;
          if (!((cmd0xe07.OCRRspBody)localObject3).languageList.has()) {
            break label1075;
          }
          n = k;
          m = j;
          localObject2 = ((cmd0xe07.OCRRspBody)localObject3).languageList.get();
          if (localObject2 == null) {
            break label1075;
          }
          n = k;
          m = j;
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            n = k;
            m = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            n = k;
            m = j;
            localObject5 = (cmd0xe07.Language)((Iterator)localObject2).next();
            n = k;
            m = j;
            localObject4 = ((cmd0xe07.Language)localObject5).language.get();
            n = k;
            m = j;
            localObject5 = ((cmd0xe07.Language)localObject5).languageDesc.get();
            n = k;
            m = j;
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              n = k;
              m = j;
              localHashMap.put(localObject4, localObject5);
            }
          }
          bool2 = false;
        }
        catch (Exception localException1)
        {
          j = n;
          localObject3 = paramObject;
          k = m;
          paramObject = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)localObject3;
        }
      }
      catch (Exception localException6)
      {
        j = -1;
        localObject1 = paramObject;
        paramObject = paramToServiceMsg;
        localObject3 = null;
        k = -1;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = localObject3;
        break label606;
        i1 = -1;
        break label1426;
        m = i;
        n = k;
        i1 = j;
        localObject3 = paramObject;
        localObject4 = paramFromServiceMsg;
        localObject5 = paramToServiceMsg;
        localObject6 = localObject1;
        break label706;
      }
      m = i;
      n = j;
      i1 = k;
      localObject3 = paramToServiceMsg;
      localObject4 = paramFromServiceMsg;
      localObject5 = paramObject;
      localObject6 = localObject1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp seq:" + l + ", exp:", localException1);
        bool1 = bool2;
        localObject6 = localObject1;
        localObject5 = paramObject;
        localObject4 = paramFromServiceMsg;
        localObject3 = paramToServiceMsg;
        i1 = k;
        n = j;
        m = i;
      }
    }
    for (;;)
    {
      label706:
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrHandler", 2, "handleRequestPicOcrRsp seq:" + l + ", succ:" + bool1 + ",result:" + m + ", requestId:" + (String)localObject3 + ", errMsg:" + (String)localObject5 + ", wording:" + (String)localObject4 + ", size:" + localArrayList1.size() + ", lag:" + (String)localObject6 + ", baseW:" + i1 + ", baseH:" + n + ", mapSize:" + localHashMap.size() + ", length:" + i2 + ", width:" + i3 + ", height" + i4);
      }
      if (bool1)
      {
        localaqnb.jdField_a_of_type_JavaLangString = str1;
        localaqnb.jdField_b_of_type_JavaLangString = ((String)localObject6);
        localaqnb.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList2);
        localaqnb.jdField_a_of_type_Int = i1;
        localaqnb.jdField_b_of_type_Int = n;
        localaqnb.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList1);
        localaqnb.jdField_c_of_type_JavaLangString = str2;
        localaqnb.jdField_a_of_type_JavaUtilHashMap = localHashMap;
        localaqnb.jdField_c_of_type_Int = i2;
        localaqnb.jdField_d_of_type_Int = i3;
        localaqnb.e = i4;
        localaqnb.jdField_d_of_type_JavaLangString = str3;
      }
      try
      {
        paramToServiceMsg = (aqmu)this.app.getManager(353);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.a(str1, localaqnb);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          label1075:
          Iterator localIterator1;
          label1426:
          QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp Exception:", paramToServiceMsg);
          continue;
          paramToServiceMsg = "1";
        }
      }
      notifyUI(100, bool1, localaqnb);
      paramFromServiceMsg = new HashMap();
      if (bool1)
      {
        paramToServiceMsg = "0";
        paramFromServiceMsg.put("param_result", paramToServiceMsg);
        axrl.a(BaseApplication.getContext()).a("", "actPicOcrResult", true, 0L, 0L, paramFromServiceMsg, "");
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label222;
        n = k;
        m = j;
        if (!((cmd0xe07.OCRRspBody)localObject3).textDetections.has()) {
          break label1679;
        }
        n = k;
        m = j;
        localIterator1 = ((cmd0xe07.OCRRspBody)localObject3).textDetections.get().iterator();
        for (;;)
        {
          n = k;
          m = j;
          if (!localIterator1.hasNext()) {
            break label1679;
          }
          n = k;
          m = j;
          localObject6 = (cmd0xe07.TextDetection)localIterator1.next();
          n = k;
          m = j;
          localObject3 = new aqmz();
          n = k;
          m = j;
          localObject4 = ((cmd0xe07.TextDetection)localObject6).detectedText.get();
          n = k;
          m = j;
          int i5 = ((cmd0xe07.TextDetection)localObject6).confidence.get();
          n = k;
          m = j;
          localObject5 = new ArrayList();
          n = k;
          m = j;
          Iterator localIterator2 = ((cmd0xe07.Polygon)((cmd0xe07.TextDetection)localObject6).polygon.get()).coordinates.get().iterator();
          for (;;)
          {
            n = k;
            m = j;
            if (!localIterator2.hasNext()) {
              break;
            }
            n = k;
            m = j;
            cmd0xe07.Coordinate localCoordinate = (cmd0xe07.Coordinate)localIterator2.next();
            n = k;
            m = j;
            ((ArrayList)localObject5).add(new aqna(localCoordinate.X.get(), localCoordinate.Y.get()));
          }
          n = k;
          m = j;
          if (!((cmd0xe07.TextDetection)localObject6).advancedInfo.has()) {
            break;
          }
          n = k;
          m = j;
          localObject6 = ((cmd0xe07.TextDetection)localObject6).advancedInfo.get();
          n = k;
          m = j;
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            break;
          }
          n = k;
          m = j;
          i1 = new JSONObject(new JSONObject((String)localObject6).optString("Parag")).optInt("ParagNo");
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_a_of_type_Int = i5;
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject5);
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_b_of_type_Int = i1;
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_c_of_type_Int = j;
          n = k;
          m = j;
          ((aqmz)localObject3).jdField_d_of_type_Int = k;
          n = k;
          m = j;
          localArrayList1.add(localObject3);
        }
      }
      label1679:
      i1 = -1;
      localObject4 = null;
      localObject6 = null;
      localObject5 = null;
      m = -1;
      n = -1;
      localObject3 = null;
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicOcrHandler", 2, "requestPicOcr seq:" + paramLong + ", url:" + paramString1 + ", orimd5:" + paramString2 + ", afMd5:" + paramString3 + ", size:" + paramInt2 + ", width:" + paramInt3 + ", height:" + paramInt4 + ", crop" + paramBoolean + "， lang：" + paramString4);
    }
    cmd0xe07.OCRReqBody localOCRReqBody = new cmd0xe07.OCRReqBody();
    localOCRReqBody.imageUrl.set(paramString1);
    if (!TextUtils.isEmpty(paramString4)) {
      localOCRReqBody.languageType.set(paramString4);
    }
    localOCRReqBody.originMd5.set(paramString2);
    localOCRReqBody.afterCompressMd5.set(paramString3);
    localOCRReqBody.afterCompressFileSize.set(paramInt2);
    localOCRReqBody.afterCompressWeight.set(paramInt3);
    localOCRReqBody.afterCompressHeight.set(paramInt4);
    localOCRReqBody.isCut.set(paramBoolean);
    paramString4 = new cmd0xe07.ReqBody();
    paramString4.version.set(1);
    paramString4.client.set(0);
    paramString4.entrance.set(a(paramInt1));
    paramString4.ocrReqBody.set(localOCRReqBody);
    paramString4 = makeOIDBPkg("OidbSvc.0xe07_0", 3591, 0, paramString4.toByteArray());
    paramString4.getAttributes().put("key_ocr_seq", Long.valueOf(paramLong));
    paramString4.getAttributes().put("key_ocr_md5", paramString2);
    paramString4.getAttributes().put("key_ocr_url", paramString1);
    paramString4.getAttributes().put("key_ocr_size", Integer.valueOf(paramInt2));
    paramString4.getAttributes().put("key_ocr_width", Integer.valueOf(paramInt3));
    paramString4.getAttributes().put("key_ocr_height", Integer.valueOf(paramInt4));
    paramString4.getAttributes().put("key_ocr_afmd5", paramString3);
    sendPbReq(paramString4);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xe07_0");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return aqmy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
      return;
    } while (!"OidbSvc.0xe07_0".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmt
 * JD-Core Version:    0.7.0.1
 */