import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import java.util.ArrayList;

public class awmh
  extends awlw
{
  private int a;
  private String b;
  private String c;
  
  public awmh(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    super(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    paramQQAppInterface = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
    this.jdField_b_of_type_JavaLangString = String.valueOf(paramQQAppInterface.uin);
    this.jdField_c_of_type_JavaLangString = paramQQAppInterface.senderuin;
    this.jdField_a_of_type_Int = paramQQAppInterface.istroop;
    a();
  }
  
  public CharSequence a()
  {
    FTSMessage localFTSMessage;
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.matchTitle == null) {
        break label35;
      }
      this.jdField_b_of_type_JavaLangCharSequence = localFTSMessage.matchTitle;
    }
    for (;;)
    {
      return this.jdField_b_of_type_JavaLangCharSequence;
      label35:
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localFTSMessage.senderuin);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      if ("80000000".equals(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangCharSequence = ajya.a(2131704963);
      } else {
        this.jdField_b_of_type_JavaLangCharSequence = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, bool, localFTSMessage.senderuin);
      }
    }
  }
  
  public void a(View paramView)
  {
    ahpd.jdField_a_of_type_Boolean = true;
    FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
    if (localFTSMessage.msgExts != null) {
      if ((localFTSMessage.istroop != 1) && (localFTSMessage.istroop != 3000)) {
        break label173;
      }
    }
    label173:
    for (ahpd.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).shmsgseq;; ahpd.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time)
    {
      bbmp.d = localFTSMessage.searchStrategy;
      bbmp.f = 1;
      bbmp.g = this.jdField_a_of_type_Int;
      bbmp.h = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).senderNum;
      bbmp.i = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).friendNum;
      bbmp.j = ((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).friendIndex;
      bbmo.a(paramView);
      ahpd.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int), false);
      akgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      awwa.a(this.jdField_a_of_type_JavaLangString, 40, paramView, true);
      return;
    }
  }
  
  public String b()
  {
    return String.valueOf(((FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity).senderuin);
  }
  
  public CharSequence c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_JavaLangCharSequence = "";
      FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.msgExts != null) {
        this.jdField_a_of_type_JavaLangCharSequence = bbkp.a(BaseApplicationImpl.sApplication, 3, ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time * 1000L);
      }
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence e()
  {
    if (this.jdField_c_of_type_JavaLangCharSequence == null)
    {
      FTSMessage localFTSMessage = (FTSMessage)this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity;
      if (localFTSMessage.matchSecondTitle != null) {
        this.jdField_c_of_type_JavaLangCharSequence = localFTSMessage.matchSecondTitle;
      }
    }
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmh
 * JD-Core Version:    0.7.0.1
 */