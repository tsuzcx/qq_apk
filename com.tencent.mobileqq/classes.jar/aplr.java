import android.content.res.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

class aplr
  implements apux
{
  aplr(aplq paramaplq, long paramLong, boolean paramBoolean, String paramString1, String paramString2, short paramShort, String paramString3) {}
  
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
      this.jdField_a_of_type_Aplq.jdField_a_of_type_Apaf.aD_();
      return;
    }
    if (this.jdField_a_of_type_Long == -100001L) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      long l = 9360L;
      if (this.jdField_a_of_type_Long == 0L) {
        l = 9048L;
      }
      this.jdField_a_of_type_Aplq.jdField_a_of_type_Apaf.a((int)l, BaseApplication.getContext().getResources().getString(2131690922));
      return;
      if ((this.jdField_a_of_type_Long == -25081L) || (this.jdField_a_of_type_Long == -6101L) || (this.jdField_a_of_type_Long == -7003L))
      {
        this.jdField_a_of_type_Aplq.jdField_a_of_type_Aplp.a(true);
        this.jdField_a_of_type_Aplq.jdField_a_of_type_Apaf.a((int)this.jdField_a_of_type_Long, BaseApplication.getContext().getResources().getString(2131692889));
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aplq.jdField_a_of_type_Apaf.a((int)9045L, BaseApplication.getContext().getResources().getString(2131690922));
        return;
      }
    }
    Object localObject1 = this.b;
    Object localObject2 = "http://" + this.jdField_a_of_type_JavaLangString + ":" + String.valueOf(this.jdField_a_of_type_Short) + this.c;
    this.jdField_a_of_type_Aplq.jdField_a_of_type_Apaf.a((String)localObject2, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplr
 * JD-Core Version:    0.7.0.1
 */