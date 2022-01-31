import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.1;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.3;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.4;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anje
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MessageForNearbyMarketGrayTips jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private int c;
  private int d;
  private int e = 2147483647;
  
  public anje(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, MessageForNearbyMarketGrayTips paramMessageForNearbyMarketGrayTips)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips = paramMessageForNearbyMarketGrayTips;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return null;
    }
    localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(93);
    if (localObject != null) {
      return ((NearbyGrayTipsManager)localObject).a(this.c, paramInt, paramBoolean);
    }
    return "";
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return null;
    }
    localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(93);
    if (localObject != null) {
      return ((NearbyGrayTipsManager)localObject).a(this.c, paramBoolean);
    }
    return "";
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "clickJumpWeb, url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while (localContext == null);
    Object localObject = paramString;
    if (paramString.contains("strangerUin=xxx")) {
      localObject = paramString.replace("strangerUin=xxx", "strangerUin=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramString = (String)localObject;
    if (localQQAppInterface != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).contains("sign=xxx"))
      {
        if (1001 != this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop) {
          break label352;
        }
        paramString = ((String)localObject).replace("sign=xxx", "sign=" + bbbd.a(localQQAppInterface.a().m(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
      }
      localObject = paramString;
      if (paramString.contains("sourceType=xxx"))
      {
        if (1001 != this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop) {
          break label472;
        }
        localObject = paramString.replace("sourceType=xxx", "sourceType=1");
      }
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (((String)localObject).equals("https://imgcache.qq.com/club/client/flower/release/html/index.html"))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin;
        localObject = bbbd.a(localQQAppInterface.a().m(paramString));
        localObject = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { atbn.a(paramString), ((String)localObject).toLowerCase(), Integer.valueOf(1), "aio.plus.s", "" });
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForNearbyMarketGrayTips", 2, "jump flow store, " + (String)localObject);
          paramString = (String)localObject;
        }
      }
      localObject = new Intent(localContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramString));
      localContext.startActivity((Intent)localObject);
      return;
      label352:
      if (1010 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop)
      {
        paramString = ((String)localObject).replace("sign=xxx", "sign=" + bbbd.a(localQQAppInterface.a().p(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
        break;
      }
      paramString = (String)localObject;
      if (10002 != this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop) {
        break;
      }
      paramString = ((String)localObject).replace("sign=xxx", "sign=" + bbbd.a(localQQAppInterface.a().k(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
      break;
      label472:
      localObject = paramString;
      if (1010 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop) {
        localObject = paramString.replace("sourceType=xxx", "sourceType=2");
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "clickJumpNative, schema = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Context localContext;
    do
    {
      return;
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (localContext == null));
    Object localObject = bbej.a((QQAppInterface)localObject, localContext, paramString);
    if (localObject != null)
    {
      ((bbds)localObject).c();
      return;
    }
    a(paramString);
  }
  
  public void c(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "clickAutoInput, content = " + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {}
    long l;
    do
    {
      return;
      l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (l <= 5000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MessageForNearbyMarketGrayTips", 2, "clickAutoInput, time = " + l);
    return;
    ((atbc)localQQAppInterface.a(66)).a("tag_nearby_chat", paramString, null);
    ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.4(this, localQQAppInterface), 2, null, false);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null)
    {
      axqw.b(localQQAppInterface, "CliOper", "", "", "0X800524C", "0X800524C", 0, 0, String.valueOf(this.c), "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.AioType == 0)
      {
        paramView = "0";
        axqw.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_link", 0, 0, paramView, "", "", "");
      }
    }
    else
    {
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    label343:
    label350:
    do
    {
      do
      {
        return;
        paramView = "1";
        break;
        a(this.jdField_a_of_type_JavaLangString);
        return;
        b(this.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramView = a(false);
        if (TextUtils.isEmpty(paramView))
        {
          ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.1(this), 5, null, true);
          return;
        }
        c(paramView);
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE. mGender=" + this.e);
        }
      } while (localQQAppInterface == null);
      if (asyu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips, "isFaceScoreSecondMember"))
      {
        paramView = "2";
        if (!asyu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips, "isFaceScoreSpecialLike")) {
          break label343;
        }
      }
      for (String str = "2";; str = "1")
      {
        asyu.a("clk_hi", this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin, new String[] { paramView, "", "", str });
        if (this.e != 2147483647) {
          break label350;
        }
        ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.2(this, localQQAppInterface), 5, null, true);
        return;
        paramView = "1";
        break;
      }
      paramView = a(this.e, false);
      if (TextUtils.isEmpty(paramView))
      {
        ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.3(this), 5, null, true);
        return;
      }
      c(paramView);
    } while (!QLog.isColorLevel());
    QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE. from cache. FaceScoreWording=" + paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anje
 * JD-Core Version:    0.7.0.1
 */