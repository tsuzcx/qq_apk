import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class aumm
  extends auml
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
  
  public aumm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aumm(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static aumn a(MessageRecord paramMessageRecord, aywa paramaywa)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramaywa.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramaywa = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramaywa.equals("")))
        {
          aumn localaumn = new aumn();
          localaumn.jdField_a_of_type_JavaLangString = paramaywa;
          localaumn.jdField_a_of_type_Long = l;
          localaumn.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localaumn;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, aumn paramaumn)
  {
    if ((paramaumn != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramaumn.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramaumn.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramaumn.b);
    }
  }
  
  public auob a(Intent paramIntent)
  {
    auob localauob = super.a(paramIntent);
    if ((paramIntent != null) && (localauob != null))
    {
      aumn localaumn = new aumn();
      localaumn.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localaumn.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localaumn.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localauob.a = localaumn;
      localauob.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localauob.n = paramIntent.getStringExtra("key_emotion_source_info");
      localauob.o = paramIntent.getStringExtra("key_emotion_source_weburl");
      localauob.p = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localauob.q = paramIntent.getStringExtra("key_emotion_source_packagename");
      localauob.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localauob;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, auob paramauob)
  {
    super.a(paramMessageForPic, paramauob);
    a(paramMessageForPic, paramauob.a);
    Object localObject = paramMessageForPic.picExtraData;
    paramauob = (auob)localObject;
    if (localObject == null) {
      paramauob = new PicMessageExtraData();
    }
    if (this.jdField_a_of_type_Int == 1042)
    {
      paramauob.imageBizType = 2;
      paramauob.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691289);
      paramMessageForPic.picExtraData = paramauob;
    }
    while (this.jdField_a_of_type_Int != 1047) {
      return;
    }
    paramauob.imageBizType = 7;
    localObject = aexd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramauob.textSummary = ("[" + (String)localObject + "]");
    }
    paramMessageForPic.picExtraData = paramauob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumm
 * JD-Core Version:    0.7.0.1
 */