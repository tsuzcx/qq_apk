import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class atvz
  implements auek
{
  atvz(atvy paramatvy, long paramLong, boolean paramBoolean1, String paramString1, Bundle paramBundle, short paramShort, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("shouq_bus_type", "bus_type_video_file");
      localObject2 = new TVK_PlayerVideoInfo();
      ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap((Map)localObject1);
      ((TVK_PlayerVideoInfo)localObject2).setPlayType(4);
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("RawVideoPlay", "true");
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
      this.jdField_a_of_type_Atvy.jdField_a_of_type_Atmc.a();
      return;
    }
    if (this.jdField_a_of_type_Long == -100001L) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      long l = 9360L;
      if (this.jdField_a_of_type_Long == 0L) {
        l = 9048L;
      }
      this.jdField_a_of_type_Atvy.jdField_a_of_type_Atmc.a((int)l, BaseApplication.getContext().getResources().getString(2131690943));
      return;
      if ((this.jdField_a_of_type_Long == -25081L) || (this.jdField_a_of_type_Long == -6101L) || (this.jdField_a_of_type_Long == -7003L))
      {
        this.jdField_a_of_type_Atvy.jdField_a_of_type_Atvx.a(true);
        this.jdField_a_of_type_Atvy.jdField_a_of_type_Atmc.a((int)this.jdField_a_of_type_Long, BaseApplication.getContext().getResources().getString(2131692655));
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Atvy.jdField_a_of_type_Atmc.a((int)9045L, BaseApplication.getContext().getResources().getString(2131690943));
        return;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = "";
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("IPv6Dns", "");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("ipv6list");
    }
    localObject1 = atvx.a(this.jdField_a_of_type_Atvy.jdField_a_of_type_Atvx, (String)localObject2, this.jdField_a_of_type_Short, (List)localObject1, this.jdField_b_of_type_Boolean);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject1 = "http://" + (String)localObject1 + ":" + String.valueOf(this.jdField_a_of_type_Short) + this.c;
      this.jdField_a_of_type_Atvy.jdField_a_of_type_Atmc.a((String)localObject1, (String)localObject2);
      return;
      localObject1 = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvz
 * JD-Core Version:    0.7.0.1
 */