import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bbpo
  extends bbpi
  implements View.OnClickListener
{
  private alwx jdField_a_of_type_Alwx = new bbpp(this);
  private bbpv jdField_a_of_type_Bbpv;
  private bbqg jdField_a_of_type_Bbqg;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private TroopAioKeywordTipInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopAioKeywordTipBar.4(this);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MessageRecord jdField_b_of_type_ComTencentMobileqqDataMessageRecord;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = paramTroopAioKeywordTipInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (!b()) {
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Aeqo.a(paramMessageRecord.uniseq);
    if (this.jdField_a_of_type_Bbpv == null)
    {
      this.jdField_a_of_type_Bbpv = new bbpv(this);
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560397, null));
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378312));
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378315));
      this.jdField_a_of_type_Bbpv.b = ((TextView)this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378314));
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378311));
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850080);
    }
    this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843458);
    for (;;)
    {
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.icon);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = bdhj.b();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setDecodeHandler(bcyz.a);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        this.jdField_a_of_type_Bbpv.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject1);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title))
        {
          this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary)) {
            break label688;
          }
          this.jdField_a_of_type_Bbpv.b.setVisibility(8);
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup) < 0)
          {
            localObject1 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
          int i = bbqa.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131378474, 2131373445, 2131373530, 2131373525 });
          if (i > 0) {
            ((RelativeLayout.LayoutParams)localObject1).addRule(3, i);
          }
          this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          localObject1 = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
          ((Animation)localObject1).setDuration(500L);
          this.jdField_b_of_type_Boolean = true;
          ((Animation)localObject1).setAnimationListener(new bbpq(this));
          if (this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.getAnimation() == null) {
            this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject1);
          }
          localObject2 = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("notice_center_new");
          if (!paramMessageRecord.isSend()) {
            break label719;
          }
          localObject1 = "exp_keyword_input";
          ((azqx)localObject2).d((String)localObject1).a(new String[] { paramMessageRecord.frienduin, String.valueOf(paramTroopAioKeywordTipInfo.ruleId), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword") }).a();
          return;
        }
      }
      catch (MalformedURLException paramMessageRecord)
      {
        QLog.i("TroopAioKeywordTipBar", 1, "tryShow,e=" + paramMessageRecord.toString());
        return;
      }
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.title);
      continue;
      label688:
      this.jdField_a_of_type_Bbpv.b.setVisibility(0);
      this.jdField_a_of_type_Bbpv.b.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.summary);
      continue;
      label719:
      Object localObject1 = "exp_keyword_msg";
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt < 0) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    } while ((paramInt < i - j) || (paramInt > k - m));
    return true;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return a(this.jdField_a_of_type_Aeqo.b(paramMessageRecord.uniseq));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bbpv == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup) < 0)) {}
    TranslateAnimation localTranslateAnimation;
    do
    {
      return;
      localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setAnimationListener(new bbpr(this, paramBoolean));
    } while (this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.getAnimation() != null);
    this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
  }
  
  private boolean b()
  {
    boolean bool = true;
    if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo == null)) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("tryShow, not inVisiblePosition,tipInfo is null");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) {
          break label64;
        }
        QLog.i("TroopAioKeywordTipBar", 2, bool);
      }
    }
    label64:
    label94:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        if (this.f == 0) {
          break label94;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopAioKeywordTipBar", 2, "tryShow, mScrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE");
      return false;
      if ((this.jdField_a_of_type_Bbqg == null) || (!this.jdField_a_of_type_Bbqg.g())) {
        break label129;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "tryShow, hasRightTopTipBar");
    return false;
    label129:
    return true;
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend())) {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend())) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword") + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId);
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_Bbpv != null) {
      return this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup;
    }
    return null;
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.f = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollStateChange,isInitSuccess == false");
      }
    }
    do
    {
      return;
      if (this.f == 0)
      {
        if ((this.jdField_b_of_type_Boolean) && (!a(this.jdField_d_of_type_Int))) {
          b(false);
        }
        a(paramLong);
        return;
      }
    } while (!this.c);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.c = false;
  }
  
  public void a(long paramLong)
  {
    if (!this.c)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
      this.c = true;
    }
  }
  
  public void a(bbqg parambbqg)
  {
    this.jdField_a_of_type_Bbqg = parambbqg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
  }
  
  protected void d()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_Bbpv != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup) >= 0))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Bbpv = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioScrollToBottom,isInitSuccess == false");
      }
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Aeqo.a().size();
      if (i != this.e) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "curMsgCount == mLastScrollToBottomListViewCount");
    return;
    this.e = i;
    a(0, 0L);
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "onAioListRefresh,isInitSuccess == false");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Aeqo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
    {
      QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo == null || mCurrentTipMR != null");
      return;
    }
    h();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url)) {}
    label524:
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url;
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$GCODE$")) {
          paramView = ((String)localObject).replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$TEXT$")) {
          break label524;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText)) {
          continue;
        }
        paramView = paramView.replace("$TEXT$", bdfr.encodeToString(((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).sb.toString().getBytes(), 0));
        localObject = paramView;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url.contains("$KEYWORD$")) {
          localObject = paramView.replace("$KEYWORD$", bdfr.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword").getBytes(), 0));
        }
        if (!((String)localObject).startsWith("http")) {
          continue;
        }
        paramView = new Intent();
        paramView.setClass(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "onClick, url=" + (String)localObject);
        }
      }
      catch (Exception paramView)
      {
        Object localObject;
        QLog.i("TroopAioKeywordTipBar", 1, "error=" + paramView.toString() + ",url=" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.url);
        continue;
      }
      localObject = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("notice_center_new");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend())
      {
        paramView = "clk_keyword_input";
        ((azqx)localObject).d(paramView).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipInfo.ruleId), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword") }).a();
        b(true);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg))
          {
            paramView = paramView.replace("$TEXT$", bdfr.encodeToString(((AbsShareMsg)((MessageForStructing)localObject).structingMsg).mContentTitle.getBytes(), 0));
            continue;
            if (((String)localObject).startsWith("mqqapi"))
            {
              paramView = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject);
              if (paramView != null)
              {
                paramView.c();
                continue;
                QLog.i("TroopAioKeywordTipBar", 1, "mCurrentTipInfo.url is empty");
              }
            }
          }
        }
      }
      else
      {
        paramView = "clk_keyword_msg";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpo
 * JD-Core Version:    0.7.0.1
 */