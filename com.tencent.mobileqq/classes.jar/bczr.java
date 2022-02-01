import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;

public class bczr
  extends QQText
{
  public bczr(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord, Object paramObject)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramMessageRecord);
    a(paramObject);
  }
  
  private void a(Object paramObject)
  {
    addSpan(paramObject, 0, BaseApplication.getContext().getString(2131690220).length(), 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczr
 * JD-Core Version:    0.7.0.1
 */