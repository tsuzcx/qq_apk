import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bfyz
  extends bfyf
{
  public bfyz(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 24;
  }
  
  public int a(int paramInt)
  {
    return 2130838574;
  }
  
  @Nullable
  public bfyg a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    Object localObject = (anwa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    paramList = "";
    if (localObject != null)
    {
      localObject = ((anwa)localObject).a(paramObject);
      if ((localObject != null) && (((HotChatItemData)localObject).mGameId > 0))
      {
        paramObject = HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((HotChatItemData)localObject).mHotChatCode, ((HotChatItemData)localObject).mGameId);
        if (paramObject != null)
        {
          paramList = paramObject.wording;
          paramInt1 = 1;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject).mHotChatCode + " " + ((HotChatItemData)localObject).mGameId);
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        return new bfyg(true, paramList, null, null, paramObject);
        paramInt1 = 0;
        paramObject = null;
        break;
      }
      return null;
      paramObject = null;
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramString = anvx.a(2131714523);
    paramTextView2.setMaxWidth((int)paramTextView2.getPaint().measureText(paramString));
    paramTextView2.requestLayout();
    paramTextView1.setVisibility(8);
    paramTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166254));
    paramImageView.setBackgroundResource(2130838575);
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onClick] into page");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyz
 * JD-Core Version:    0.7.0.1
 */