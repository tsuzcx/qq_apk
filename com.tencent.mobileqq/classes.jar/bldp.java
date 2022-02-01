import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.QSecPushSeriveMsg.QSecPushSeriveBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecPushServiceMgr.1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class bldp
{
  private int jdField_a_of_type_Int;
  private blcv jdField_a_of_type_Blcv;
  private bldg jdField_a_of_type_Bldg;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<Integer, List<bldr>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bldp(bldg parambldg, blcv paramblcv)
  {
    this.jdField_a_of_type_Bldg = parambldg;
    this.jdField_a_of_type_Blcv = paramblcv;
    this.jdField_a_of_type_Bldg.a(new bldq(this));
  }
  
  private bldr a(byte[] paramArrayOfByte)
  {
    int j = -1;
    boolean bool = true;
    int i;
    try
    {
      localQSecPushSeriveBody = new QSecPushSeriveMsg.QSecPushSeriveBody();
      localQSecPushSeriveBody.mergeFrom(paramArrayOfByte);
      if ((localQSecPushSeriveBody.ver == null) || (!localQSecPushSeriveBody.ver.has())) {
        break label411;
      }
      i = localQSecPushSeriveBody.ver.get();
    }
    catch (Exception paramArrayOfByte)
    {
      QSecPushSeriveMsg.QSecPushSeriveBody localQSecPushSeriveBody;
      label80:
      paramArrayOfByte.printStackTrace();
      return null;
    }
    if ((localQSecPushSeriveBody.platform != null) && (localQSecPushSeriveBody.platform.has()))
    {
      i = localQSecPushSeriveBody.platform.get();
      if ((i & 0x1) == 0) {
        break label418;
      }
      if ((localQSecPushSeriveBody.qsecJavaVer != null) && (localQSecPushSeriveBody.qsecJavaVer.has()))
      {
        i = localQSecPushSeriveBody.qsecJavaVer.get();
        break label420;
      }
    }
    for (;;)
    {
      i = j;
      if (localQSecPushSeriveBody.qsecNativeVer != null)
      {
        i = j;
        if (localQSecPushSeriveBody.qsecNativeVer.has()) {
          i = localQSecPushSeriveBody.qsecNativeVer.get();
        }
      }
      if ((i == 0) || (i == QSecFramework.a().a()))
      {
        if ((localQSecPushSeriveBody.packageName != null) && (localQSecPushSeriveBody.packageName.has())) {
          paramArrayOfByte = localQSecPushSeriveBody.packageName.get();
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(paramArrayOfByte)) || (paramArrayOfByte.equalsIgnoreCase(blbf.c())))
          {
            paramArrayOfByte = new bldr(null);
            if ((localQSecPushSeriveBody.pluginId != null) && (localQSecPushSeriveBody.pluginId.has()))
            {
              paramArrayOfByte.jdField_a_of_type_Int = localQSecPushSeriveBody.pluginId.get();
              if ((localQSecPushSeriveBody.pluginCmd != null) && (localQSecPushSeriveBody.pluginCmd.has()))
              {
                paramArrayOfByte.c = localQSecPushSeriveBody.pluginCmd.get();
                if ((localQSecPushSeriveBody.pluginVer != null) && (localQSecPushSeriveBody.pluginVer.has()))
                {
                  paramArrayOfByte.b = localQSecPushSeriveBody.pluginVer.get();
                  if ((localQSecPushSeriveBody.canCache != null) && (localQSecPushSeriveBody.canCache.has())) {
                    if (localQSecPushSeriveBody.canCache.get() != 1) {
                      break label383;
                    }
                  }
                  for (;;)
                  {
                    paramArrayOfByte.jdField_a_of_type_Boolean = bool;
                    if ((localQSecPushSeriveBody.extraInfo != null) && (localQSecPushSeriveBody.extraInfo.has())) {
                      paramArrayOfByte.jdField_a_of_type_ArrayOfByte = localQSecPushSeriveBody.extraInfo.get().toByteArray();
                    }
                    return paramArrayOfByte;
                    label383:
                    bool = false;
                  }
                  paramArrayOfByte = null;
                  continue;
                  i = -1;
                  break label420;
                  i = 0;
                  break label80;
                  label411:
                  i = 0;
                  if (i == 1) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
      label418:
      label420:
      do
      {
        return null;
        if (i == 0) {
          break;
        }
      } while (i != 33751040);
    }
  }
  
  private void a(bldr parambldr)
  {
    if (parambldr.jdField_a_of_type_Int == 0)
    {
      c(parambldr);
      return;
    }
    b(parambldr);
  }
  
  private void b(bldr parambldr)
  {
    int i = this.jdField_a_of_type_Bldg.a(parambldr.jdField_a_of_type_Int, parambldr.b, parambldr.c, new Object[] { parambldr.jdField_a_of_type_ArrayOfByte }, null);
    if (((i == 17) || (i == 7) || (i == 4)) && (parambldr.jdField_a_of_type_Boolean)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Int < 50)
        {
          List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambldr.jdField_a_of_type_Int));
          Object localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new LinkedList();
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(parambldr.jdField_a_of_type_Int), localObject1);
          }
          ((List)localObject1).add(parambldr);
          this.jdField_a_of_type_Int += 1;
        }
        return;
      }
    }
  }
  
  private void c(bldr parambldr)
  {
    switch (parambldr.c)
    {
    }
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Blcv.a(true);
        return;
        try
        {
          parambldr = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
          if (parambldr != null)
          {
            ((blee)parambldr.getManager(194)).b(0);
            return;
          }
        }
        catch (Exception parambldr)
        {
          return;
        }
      }
      parambldr = parambldr.jdField_a_of_type_ArrayOfByte;
    } while (!blcg.a().a(parambldr));
    blcg.a().a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    QSecFramework.a().post(new QSecPushServiceMgr.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldp
 * JD-Core Version:    0.7.0.1
 */