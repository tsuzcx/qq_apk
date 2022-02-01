import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public abstract class bfhq
  implements bfht
{
  protected int a;
  protected Context a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected final String a;
  
  public bfhq(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_JavaLangString = ("Navigate." + getClass().getSimpleName());
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @DrawableRes
  public int a(int paramInt)
  {
    return 0;
  }
  
  public bfhq a(int paramInt)
  {
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString) {}
  
  public void a(int paramInt1, bepx parambepx, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    return false;
  }
  
  protected boolean a(@NonNull MessageRecord paramMessageRecord, long paramLong1, long paramLong2)
  {
    if ((paramMessageRecord.shmsgseq <= paramLong2) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkShMsgSeqCanShow, shMsgSeq = " + paramMessageRecord.shmsgseq + ", firstMsgSeq = " + paramLong1 + ", lastReadSeq = " + paramLong2);
    }
    return (paramMessageRecord.shmsgseq < paramLong1) && (paramMessageRecord.shmsgseq > paramLong2);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhq
 * JD-Core Version:    0.7.0.1
 */