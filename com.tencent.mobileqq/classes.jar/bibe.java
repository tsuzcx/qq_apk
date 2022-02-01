import MQQ.QQValueInfoItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.profilecard.VaProfileGate.QQValueExtInfo;
import com.tencent.pb.profilecard.VaProfileGate.QQValueInfoItem;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo.ExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class bibe
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public int d = 1;
  
  public bibe()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static bibe a(Object paramObject)
  {
    int j = 0;
    int i = 0;
    bibe localbibe = new bibe();
    localbibe.jdField_a_of_type_Boolean = false;
    if ((paramObject instanceof qqvalue.UserQQValueInfo))
    {
      localbibe.jdField_b_of_type_Int = ((qqvalue.UserQQValueInfo)paramObject).level.get();
      localbibe.jdField_a_of_type_Int = ((qqvalue.UserQQValueInfo)paramObject).score.get();
      localbibe.c = ((qqvalue.UserQQValueInfo)paramObject).trend.get();
      localbibe.jdField_a_of_type_JavaLangString = ((qqvalue.UserQQValueInfo)paramObject).material_id.get();
      localbibe.jdField_b_of_type_JavaLangString = ((qqvalue.UserQQValueInfo)paramObject).url.get();
      localbibe.d = ((qqvalue.UserQQValueInfo)paramObject).on_off.get();
      if (((qqvalue.UserQQValueInfo)paramObject).ext_info.has())
      {
        paramObject = ((qqvalue.UserQQValueInfo)paramObject).ext_info.get();
        if (paramObject == null) {}
      }
      for (;;)
      {
        if (i < paramObject.size())
        {
          if (((qqvalue.UserQQValueInfo.ExtInfo)paramObject.get(i)).key.get().equals("use_static")) {
            localbibe.jdField_a_of_type_Boolean = ((qqvalue.UserQQValueInfo.ExtInfo)paramObject.get(i)).value.get().equals("1");
          }
        }
        else {
          return localbibe;
        }
        i += 1;
      }
    }
    if ((paramObject instanceof VaProfileGate.QQValueInfoItem))
    {
      localbibe.jdField_b_of_type_Int = ((VaProfileGate.QQValueInfoItem)paramObject).level.get();
      localbibe.jdField_a_of_type_Int = ((VaProfileGate.QQValueInfoItem)paramObject).score.get();
      localbibe.c = ((VaProfileGate.QQValueInfoItem)paramObject).trend.get();
      localbibe.jdField_a_of_type_JavaLangString = ((VaProfileGate.QQValueInfoItem)paramObject).material_id.get();
      localbibe.jdField_b_of_type_JavaLangString = ((VaProfileGate.QQValueInfoItem)paramObject).url.get();
      localbibe.d = ((VaProfileGate.QQValueInfoItem)paramObject).on_off.get();
      if (((VaProfileGate.QQValueInfoItem)paramObject).qqvalue_ext_info.has())
      {
        paramObject = ((VaProfileGate.QQValueInfoItem)paramObject).qqvalue_ext_info.get();
        if (paramObject != null) {
          i = j;
        }
      }
      for (;;)
      {
        if (i < paramObject.size())
        {
          if (((VaProfileGate.QQValueExtInfo)paramObject.get(i)).key.get().equals("use_static")) {
            localbibe.jdField_a_of_type_Boolean = ((VaProfileGate.QQValueExtInfo)paramObject.get(i)).value.get().equals("1");
          }
        }
        else {
          return localbibe;
        }
        i += 1;
      }
    }
    if ((paramObject instanceof QQValueInfoItem))
    {
      localbibe.jdField_b_of_type_Int = ((QQValueInfoItem)paramObject).level;
      localbibe.jdField_a_of_type_Int = ((QQValueInfoItem)paramObject).score;
      localbibe.c = ((QQValueInfoItem)paramObject).trend;
      localbibe.jdField_a_of_type_JavaLangString = ((QQValueInfoItem)paramObject).material_id;
      localbibe.jdField_b_of_type_JavaLangString = ((QQValueInfoItem)paramObject).url;
      localbibe.d = ((QQValueInfoItem)paramObject).on_off;
      paramObject = ((QQValueInfoItem)paramObject).qqvalue_ext_info;
      if ((paramObject != null) && ("1".equals(paramObject.get("use_static")))) {
        localbibe.jdField_a_of_type_Boolean = true;
      }
      return localbibe;
    }
    return null;
  }
  
  public static bibe a(@NonNull String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 == null) || (((QQAppInterface)localObject2).getCurrentUin() == null) || (!((QQAppInterface)localObject2).getCurrentUin().equals(paramString))) {
      return null;
    }
    localObject2 = new bibe();
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("sp_vip_qqvalue_info", 0);
    ((bibe)localObject2).jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt("key_info_score" + paramString, 0);
    ((bibe)localObject2).jdField_b_of_type_Int = ((SharedPreferences)localObject1).getInt("key_info_level" + paramString, 0);
    ((bibe)localObject2).c = ((SharedPreferences)localObject1).getInt("key_info_trend" + paramString, 0);
    ((bibe)localObject2).jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("key_info_material_id" + paramString, "");
    ((bibe)localObject2).jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("key_info_url" + paramString, "");
    ((bibe)localObject2).d = ((SharedPreferences)localObject1).getInt("key_info_on_off" + paramString, 1);
    if (((SharedPreferences)localObject1).getInt("key_info_static_show" + paramString, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((bibe)localObject2).jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("QQValueInfoItem", 1, "get sp score:" + ((bibe)localObject2).jdField_a_of_type_Int + " level = " + ((bibe)localObject2).jdField_b_of_type_Int + " trend = " + ((bibe)localObject2).c + "materialId = " + ((bibe)localObject2).jdField_a_of_type_JavaLangString + "url" + ((bibe)localObject2).jdField_b_of_type_JavaLangString + "on_off" + ((bibe)localObject2).d);
      }
      return localObject2;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while ((localObject2 == null) || (((QQAppInterface)localObject2).getCurrentUin() == null) || (!((QQAppInterface)localObject2).getCurrentUin().equals(paramString)));
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("sp_vip_qqvalue_info", 0);
    Object localObject2 = "key_info_score" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.jdField_a_of_type_Int);
    localObject2 = "key_info_level" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.jdField_b_of_type_Int);
    localObject2 = "key_info_trend" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.c);
    localObject2 = "key_info_material_id" + paramString;
    ((SharedPreferences)localObject1).edit().putString((String)localObject2, this.jdField_a_of_type_JavaLangString);
    localObject2 = "key_info_url" + paramString;
    ((SharedPreferences)localObject1).edit().putString((String)localObject2, this.jdField_b_of_type_JavaLangString);
    localObject2 = "key_info_on_off" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.d);
    paramString = "key_info_static_show" + paramString;
    localObject2 = ((SharedPreferences)localObject1).edit();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((SharedPreferences.Editor)localObject2).putInt(paramString, i);
      ((SharedPreferences)localObject1).edit().commit();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQValueInfoItem", 1, "save sp score:" + this.jdField_a_of_type_Int + " level = " + this.jdField_b_of_type_Int + " trend = " + this.c + "materialId = " + this.jdField_a_of_type_JavaLangString + "url" + this.jdField_b_of_type_JavaLangString + "on_off" + this.d);
      return;
    }
  }
  
  public boolean a(bibe parambibe)
  {
    if (parambibe == null) {}
    do
    {
      return false;
      if (this == parambibe) {
        return true;
      }
    } while ((!this.jdField_a_of_type_JavaLangString.equals(parambibe.jdField_a_of_type_JavaLangString)) || (this.d != parambibe.d) || (this.jdField_a_of_type_Int != parambibe.jdField_a_of_type_Int) || (this.c != parambibe.c) || (!this.jdField_b_of_type_JavaLangString.equals(parambibe.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int != parambibe.jdField_b_of_type_Int) || (this.jdField_a_of_type_Boolean != parambibe.jdField_a_of_type_Boolean));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibe
 * JD-Core Version:    0.7.0.1
 */