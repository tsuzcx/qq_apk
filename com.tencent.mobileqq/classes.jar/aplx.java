import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aplx
  implements aplr
{
  public static String a;
  public static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "videofeeds:";
    jdField_b_of_type_JavaLangString = "mainFeeds:";
  }
  
  private void a(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject1 = paramColorNote.getReserve();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = Parcel.obtain();
        ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
        ((Parcel)localObject2).setDataPosition(0);
        localObject1 = new VideoInfo((Parcel)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("VIDEO_PLAY_POSITION", paramColorNote.mExtLong);
        ((Bundle)localObject2).putBoolean("FLAG_ACTIVITY_NEW_TASK", true);
        rwv.a(paramContext, (Bundle)localObject2, 32, ((VideoInfo)localObject1).g, ((VideoInfo)localObject1).jdField_a_of_type_Int, ((VideoInfo)localObject1).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject1).b(), ((VideoInfo)localObject1).c(), ((VideoInfo)localObject1).a(), ((VideoInfo)localObject1).c, ((VideoInfo)localObject1).jdField_b_of_type_JavaLangString, ((VideoInfo)localObject1).f, ((VideoInfo)localObject1).k, ((VideoInfo)localObject1).j, ((VideoInfo)localObject1).jdField_b_of_type_Long, ((VideoInfo)localObject1).jdField_b_of_type_Boolean, ((VideoInfo)localObject1).jdField_d_of_type_Long, ((VideoInfo)localObject1).h, ((VideoInfo)localObject1).r, ((VideoInfo)localObject1).jdField_d_of_type_JavaLangString, ((VideoInfo)localObject1).o, ((VideoInfo)localObject1).p, ((VideoInfo)localObject1).e);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyLauncher", 2, "colorNote handleVideoFeedsJump() videoInfo=" + ((VideoInfo)localObject1).b());
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyLauncher", 2, "handleVideoFeedsJump", localThrowable);
          }
          VideoInfo localVideoInfo = new VideoInfo();
        }
      }
    }
  }
  
  private void b(Context paramContext, ColorNote paramColorNote)
  {
    paramColorNote = paramColorNote.getReserve();
    if (paramColorNote == null) {
      return;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramColorNote, 0, paramColorNote.length);
      localParcel.setDataPosition(0);
      paramColorNote = new ArticleInfo(localParcel);
      if (paramColorNote == null)
      {
        QLog.d("ReadInJoyLauncher", 2, "init color error something is null");
        return;
      }
    }
    catch (Exception paramColorNote)
    {
      for (;;)
      {
        QLog.e("ReadInJoyLauncher", 2, "unmarshall error");
        paramColorNote.printStackTrace();
        paramColorNote = null;
      }
      QLog.d("ReadInJoyLauncher", 2, "articleInfo From ColorNote :\n" + paramColorNote.toString());
      paramColorNote = pbi.b(paramContext, paramColorNote);
      paramColorNote.addFlags(268435456);
      paramColorNote.putExtra("from_color_note", true);
      paramColorNote.putExtra("native_article_launch_from", 1004);
      paramContext.startActivity(paramColorNote);
      tpo.a.a(paramContext);
    }
  }
  
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    if ((paramContext == null) || (paramColorNote == null) || (paramColorNote.getReserve() == null)) {
      return;
    }
    try
    {
      paramColorNote = new String(paramColorNote.getReserve());
      Object localObject = new JSONObject(paramColorNote);
      String str1 = ((JSONObject)localObject).optString("url");
      String str2 = ((JSONObject)localObject).optString("param");
      boolean bool = ((JSONObject)localObject).optBoolean("useTransParentFragment");
      localObject = new Bundle();
      ((Bundle)localObject).putString("param", str2);
      ((Bundle)localObject).putString("colorBallData", paramColorNote);
      ((Bundle)localObject).putBoolean("from_color_note", true);
      ((Bundle)localObject).putInt("fling_action_key", 2);
      ((Bundle)localObject).putInt("fling_code_key", new Object().hashCode());
      tgc.a(paramContext, null, str1, (Bundle)localObject, bool);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ReadInJoyLauncher", 1, "error: " + paramContext.getMessage());
    }
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.mSubType.startsWith(jdField_a_of_type_JavaLangString))
    {
      a(paramContext, paramColorNote);
      return;
    }
    if (paramColorNote.mSubType.startsWith("viola:"))
    {
      c(paramContext, paramColorNote);
      return;
    }
    b(paramContext, paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplx
 * JD-Core Version:    0.7.0.1
 */