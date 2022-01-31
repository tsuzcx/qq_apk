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
import java.util.Map;
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

public class asjs
  extends alpd
{
  private static Map a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(0), Integer.valueOf(0));
    a.put(Integer.valueOf(1), Integer.valueOf(1));
    a.put(Integer.valueOf(-1001), Integer.valueOf(0));
    a.put(Integer.valueOf(-1002), Integer.valueOf(1));
    a.put(Integer.valueOf(-1003), Integer.valueOf(2));
    a.put(Integer.valueOf(-1004), Integer.valueOf(3));
    a.put(Integer.valueOf(-1005), Integer.valueOf(4));
    a.put(Integer.valueOf(-1006), Integer.valueOf(5));
    a.put(Integer.valueOf(-1007), Integer.valueOf(6));
    a.put(Integer.valueOf(-1008), Integer.valueOf(7));
  }
  
  public asjs(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static int a(int paramInt)
  {
    int i = 2;
    if (a.containsKey(Integer.valueOf(paramInt))) {
      i = ((Integer)a.get(Integer.valueOf(paramInt))).intValue();
    }
    return i;
  }
  
  public void a(asjw paramasjw)
  {
    a(paramasjw.f, paramasjw.jdField_b_of_type_Long, paramasjw.jdField_d_of_type_JavaLangString, paramasjw.e, paramasjw.jdField_a_of_type_Int, (int)paramasjw.jdField_a_of_type_Long, paramasjw.jdField_b_of_type_Int, paramasjw.jdField_c_of_type_Int, paramasjw.jdField_a_of_type_Boolean, paramasjw.jdField_a_of_type_JavaLangString);
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
    aska localaska;
    HashMap localHashMap;
    int j;
    int k;
    Object localObject1;
    int i;
    label216:
    int n;
    label265:
    label286:
    int m;
    label364:
    Object localObject2;
    label401:
    Object localObject4;
    Object localObject3;
    label589:
    int i1;
    Object localObject5;
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
      localaska = new aska();
      localHashMap = new HashMap();
      j = -1;
      k = -1;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localObject1 = new cmd0xe07.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          cmd0xe07.OCRRspBody localOCRRspBody;
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
        paramToServiceMsg = ((cmd0xe07.RspBody)localObject1).errMsg.get();
      }
      catch (Exception localException3)
      {
        j = -1;
        paramToServiceMsg = null;
        paramObject = null;
        paramFromServiceMsg = null;
        localObject1 = null;
        k = -1;
        break label589;
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = ((cmd0xe07.RspBody)localObject1).wording.get();
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
          localObject2 = null;
          localObject1 = null;
          k = -1;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)localObject2;
          break;
          n = -1;
          i1 = -1;
          localObject2 = null;
          localObject5 = null;
          m = i;
          localObject3 = paramFromServiceMsg;
          localObject4 = paramToServiceMsg;
          break label689;
        }
        try
        {
          if (!((cmd0xe07.RspBody)localObject1).ocrRspBody.has()) {
            continue;
          }
          localOCRRspBody = (cmd0xe07.OCRRspBody)((cmd0xe07.RspBody)localObject1).ocrRspBody.get();
          if (localOCRRspBody.requestId.has()) {
            paramObject = localOCRRspBody.requestId.get();
          }
        }
        catch (Exception localException5)
        {
          j = -1;
          localObject2 = null;
          paramObject = paramToServiceMsg;
          localObject1 = null;
          k = -1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          break;
        }
      }
      try
      {
        if (!localOCRRspBody.language.has()) {
          break label1062;
        }
        localObject1 = localOCRRspBody.language.get();
        n = k;
        m = j;
        try
        {
          if (localOCRRspBody.ocrLanguageList.has())
          {
            n = k;
            m = j;
            localArrayList2.addAll(localOCRRspBody.ocrLanguageList.get());
          }
          n = k;
          m = j;
          if (!localOCRRspBody.afterCompressWeight.has()) {
            break label1069;
          }
          n = k;
          m = j;
          j = localOCRRspBody.afterCompressWeight.get();
          n = k;
          m = j;
          if (!localOCRRspBody.afterCompressHeight.has()) {
            break label1075;
          }
          n = k;
          m = j;
          k = localOCRRspBody.afterCompressHeight.get();
          n = k;
          m = j;
          if (!localOCRRspBody.languageList.has()) {
            break label1081;
          }
          n = k;
          m = j;
          localObject2 = localOCRRspBody.languageList.get();
          if (localObject2 == null) {
            break label1081;
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
            localObject4 = (cmd0xe07.Language)((Iterator)localObject2).next();
            n = k;
            m = j;
            localObject3 = ((cmd0xe07.Language)localObject4).language.get();
            n = k;
            m = j;
            localObject4 = ((cmd0xe07.Language)localObject4).languageDesc.get();
            n = k;
            m = j;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              n = k;
              m = j;
              localHashMap.put(localObject3, localObject4);
            }
          }
          bool2 = false;
        }
        catch (Exception localException1)
        {
          j = n;
          localObject2 = paramObject;
          k = m;
          paramObject = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)localObject2;
        }
      }
      catch (Exception localException6)
      {
        j = -1;
        localObject1 = paramObject;
        paramObject = paramToServiceMsg;
        localObject2 = null;
        k = -1;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = localObject2;
        break label589;
        i1 = -1;
        break label1432;
        m = i;
        n = k;
        i1 = j;
        localObject2 = paramObject;
        localObject3 = paramFromServiceMsg;
        localObject4 = paramToServiceMsg;
        localObject5 = localObject1;
        break label689;
      }
      m = i;
      n = j;
      i1 = k;
      localObject2 = paramToServiceMsg;
      localObject3 = paramFromServiceMsg;
      localObject4 = paramObject;
      localObject5 = localObject1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp seq:" + l + ", exp:", localException1);
        bool1 = bool2;
        localObject5 = localObject1;
        localObject4 = paramObject;
        localObject3 = paramFromServiceMsg;
        localObject2 = paramToServiceMsg;
        i1 = k;
        n = j;
        m = i;
      }
    }
    for (;;)
    {
      for (;;)
      {
        label689:
        if (QLog.isColorLevel()) {
          QLog.i("PicOcrHandler", 2, "handleRequestPicOcrRsp seq:" + l + ", succ:" + bool1 + ",result:" + m + ", requestId:" + (String)localObject2 + ", errMsg:" + (String)localObject4 + ", wording:" + (String)localObject3 + ", size:" + localArrayList1.size() + ", lag:" + (String)localObject5 + ", baseW:" + i1 + ", baseH:" + n + ", mapSize:" + localHashMap.size() + ", length:" + i2 + ", width:" + i3 + ", height" + i4);
        }
        if (bool1)
        {
          localaska.jdField_a_of_type_JavaLangString = str1;
          localaska.jdField_b_of_type_JavaLangString = ((String)localObject5);
          localaska.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList2);
          localaska.jdField_a_of_type_Int = i1;
          localaska.jdField_b_of_type_Int = n;
          localaska.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList1);
          localaska.jdField_c_of_type_JavaLangString = str2;
          localaska.jdField_a_of_type_JavaUtilHashMap = localHashMap;
          localaska.jdField_c_of_type_Int = i2;
          localaska.jdField_d_of_type_Int = i3;
          localaska.e = i4;
          localaska.jdField_d_of_type_JavaLangString = str3;
        }
        try
        {
          ((asjt)this.app.getManager(353)).a(str1, localaska);
          notifyUI(100, bool1, localaska);
          paramFromServiceMsg = new HashMap();
          if (bool1)
          {
            paramToServiceMsg = "0";
            paramFromServiceMsg.put("param_result", paramToServiceMsg);
            azri.a(BaseApplication.getContext()).a("", "actPicOcrResult", true, 0L, 0L, paramFromServiceMsg, "");
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label216;
            paramObject = "";
            break label265;
            label1062:
            localObject1 = "";
            break label286;
            label1069:
            j = -1;
            break label364;
            label1075:
            k = -1;
            break label401;
            label1081:
            n = k;
            m = j;
            if (!localException1.textDetections.has()) {
              break label1685;
            }
            n = k;
            m = j;
            Iterator localIterator1 = localException1.textDetections.get().iterator();
            for (;;)
            {
              n = k;
              m = j;
              if (!localIterator1.hasNext()) {
                break label1685;
              }
              n = k;
              m = j;
              localObject5 = (cmd0xe07.TextDetection)localIterator1.next();
              n = k;
              m = j;
              localObject2 = new asjy();
              n = k;
              m = j;
              localObject3 = ((cmd0xe07.TextDetection)localObject5).detectedText.get();
              n = k;
              m = j;
              int i5 = ((cmd0xe07.TextDetection)localObject5).confidence.get();
              n = k;
              m = j;
              localObject4 = new ArrayList();
              n = k;
              m = j;
              Iterator localIterator2 = ((cmd0xe07.Polygon)((cmd0xe07.TextDetection)localObject5).polygon.get()).coordinates.get().iterator();
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
                ((ArrayList)localObject4).add(new asjz(localCoordinate.X.get(), localCoordinate.Y.get()));
              }
              n = k;
              m = j;
              if (!((cmd0xe07.TextDetection)localObject5).advancedInfo.has()) {
                break;
              }
              n = k;
              m = j;
              localObject5 = ((cmd0xe07.TextDetection)localObject5).advancedInfo.get();
              n = k;
              m = j;
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                break;
              }
              n = k;
              m = j;
              i1 = new JSONObject(new JSONObject((String)localObject5).optString("Parag")).optInt("ParagNo");
              label1432:
              n = k;
              m = j;
              ((asjy)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
              n = k;
              m = j;
              ((asjy)localObject2).jdField_a_of_type_Int = i5;
              n = k;
              m = j;
              ((asjy)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject4);
              n = k;
              m = j;
              ((asjy)localObject2).jdField_b_of_type_Int = i1;
              n = k;
              m = j;
              ((asjy)localObject2).jdField_c_of_type_Int = j;
              n = k;
              m = j;
              ((asjy)localObject2).jdField_d_of_type_Int = k;
              n = k;
              m = j;
              localArrayList1.add(localObject2);
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp Exception:", paramToServiceMsg);
            continue;
            paramToServiceMsg = "1";
          }
        }
      }
      label1685:
      i1 = -1;
      localObject3 = null;
      localObject5 = null;
      localObject4 = null;
      m = -1;
      n = -1;
      localObject2 = null;
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
  
  protected Class<? extends alpg> observerClass()
  {
    return asjx.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjs
 * JD-Core Version:    0.7.0.1
 */