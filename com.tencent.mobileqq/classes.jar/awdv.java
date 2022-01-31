import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class awdv
  extends awdu
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
  
  public awdv(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public awdv(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static awdw a(MessageRecord paramMessageRecord, baub parambaub)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(parambaub.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        parambaub = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!parambaub.equals("")))
        {
          awdw localawdw = new awdw();
          localawdw.jdField_a_of_type_JavaLangString = parambaub;
          localawdw.jdField_a_of_type_Long = l;
          localawdw.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localawdw;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, awdw paramawdw)
  {
    if ((paramawdw != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramawdw.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramawdw.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramawdw.b);
    }
  }
  
  public awfl a(Intent paramIntent)
  {
    awfl localawfl = super.a(paramIntent);
    if ((paramIntent != null) && (localawfl != null))
    {
      awdw localawdw = new awdw();
      localawdw.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localawdw.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localawdw.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localawfl.a = localawdw;
      localawfl.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localawfl.n = paramIntent.getStringExtra("key_emotion_source_info");
      localawfl.o = paramIntent.getStringExtra("key_emotion_source_weburl");
      localawfl.p = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localawfl.q = paramIntent.getStringExtra("key_emotion_source_packagename");
      localawfl.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localawfl;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, awfl paramawfl)
  {
    super.a(paramMessageForPic, paramawfl);
    a(paramMessageForPic, paramawfl.a);
    Object localObject = paramMessageForPic.picExtraData;
    paramawfl = (awfl)localObject;
    if (localObject == null) {
      paramawfl = new PicMessageExtraData();
    }
    if (this.jdField_a_of_type_Int == 1042)
    {
      paramawfl.imageBizType = 2;
      paramawfl.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691342);
      paramMessageForPic.picExtraData = paramawfl;
    }
    while (this.jdField_a_of_type_Int != 1047) {
      return;
    }
    paramawfl.imageBizType = 7;
    localObject = agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramawfl.textSummary = ("[" + (String)localObject + "]");
    }
    paramMessageForPic.picExtraData = paramawfl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdv
 * JD-Core Version:    0.7.0.1
 */