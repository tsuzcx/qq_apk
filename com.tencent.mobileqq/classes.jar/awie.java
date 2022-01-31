import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class awie
  extends awid
{
  private static final Set<Integer> a;
  protected int a;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1042));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1030));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1047));
  }
  
  public awie(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public awie(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static awif a(MessageRecord paramMessageRecord, bayk parambayk)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(parambayk.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        parambayk = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!parambayk.equals("")))
        {
          awif localawif = new awif();
          localawif.jdField_a_of_type_JavaLangString = parambayk;
          localawif.jdField_a_of_type_Long = l;
          localawif.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localawif;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, awif paramawif)
  {
    if ((paramawif != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramawif.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramawif.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramawif.b);
    }
  }
  
  public awju a(Intent paramIntent)
  {
    awju localawju = super.a(paramIntent);
    if ((paramIntent != null) && (localawju != null))
    {
      awif localawif = new awif();
      localawif.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localawif.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localawif.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localawju.a = localawif;
      localawju.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localawju.n = paramIntent.getStringExtra("key_emotion_source_info");
      localawju.o = paramIntent.getStringExtra("key_emotion_source_weburl");
      localawju.p = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localawju.q = paramIntent.getStringExtra("key_emotion_source_packagename");
      localawju.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localawju;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, awju paramawju)
  {
    super.a(paramMessageForPic, paramawju);
    a(paramMessageForPic, paramawju.a);
    Object localObject = paramMessageForPic.picExtraData;
    paramawju = (awju)localObject;
    if (localObject == null) {
      paramawju = new PicMessageExtraData();
    }
    if (this.jdField_a_of_type_Int == 1042)
    {
      paramawju.imageBizType = 2;
      paramawju.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691343);
      paramMessageForPic.picExtraData = paramawju;
    }
    while (this.jdField_a_of_type_Int != 1047) {
      return;
    }
    paramawju.imageBizType = 7;
    localObject = agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramawju.textSummary = ("[" + (String)localObject + "]");
    }
    paramMessageForPic.picExtraData = paramawju;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awie
 * JD-Core Version:    0.7.0.1
 */