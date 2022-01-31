import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class atoo
  extends aton
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
  
  public atoo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public atoo(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static atop a(MessageRecord paramMessageRecord, axvt paramaxvt)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramaxvt.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramaxvt = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramaxvt.equals("")))
        {
          atop localatop = new atop();
          localatop.jdField_a_of_type_JavaLangString = paramaxvt;
          localatop.jdField_a_of_type_Long = l;
          localatop.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localatop;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, atop paramatop)
  {
    if ((paramatop != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramatop.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramatop.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramatop.b);
    }
  }
  
  public atqd a(Intent paramIntent)
  {
    atqd localatqd = super.a(paramIntent);
    if ((paramIntent != null) && (localatqd != null))
    {
      atop localatop = new atop();
      localatop.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localatop.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localatop.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localatqd.a = localatop;
      localatqd.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localatqd.n = paramIntent.getStringExtra("key_emotion_source_info");
      localatqd.o = paramIntent.getStringExtra("key_emotion_source_weburl");
      localatqd.p = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localatqd.q = paramIntent.getStringExtra("key_emotion_source_packagename");
      localatqd.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localatqd;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, atqd paramatqd)
  {
    super.a(paramMessageForPic, paramatqd);
    a(paramMessageForPic, paramatqd.a);
    Object localObject = paramMessageForPic.picExtraData;
    paramatqd = (atqd)localObject;
    if (localObject == null) {
      paramatqd = new PicMessageExtraData();
    }
    if (this.jdField_a_of_type_Int == 1042)
    {
      paramatqd.imageBizType = 2;
      paramatqd.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131625713);
      paramMessageForPic.picExtraData = paramatqd;
    }
    while (this.jdField_a_of_type_Int != 1047) {
      return;
    }
    paramatqd.imageBizType = 7;
    localObject = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramatqd.textSummary = ("[" + (String)localObject + "]");
    }
    paramMessageForPic.picExtraData = paramatqd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoo
 * JD-Core Version:    0.7.0.1
 */