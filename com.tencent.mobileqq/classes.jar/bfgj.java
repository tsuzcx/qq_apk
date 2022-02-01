import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bfgj
  extends ReportDialog
  implements View.OnClickListener, asmr, biza
{
  protected int a;
  protected long a;
  protected Handler a;
  protected Button a;
  protected EditText a;
  protected FrameLayout a;
  public ImageView a;
  protected bfgk a;
  public BaseActivity a;
  public SystemAndEmojiEmoticonPanel a;
  protected InputMethodRelativeLayout a;
  protected String a;
  protected ArrayList<String> a;
  protected JSONObject a;
  protected boolean a;
  protected int b;
  protected String b;
  public boolean b;
  protected String c;
  
  public bfgj(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity);
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    a(paramBundle);
  }
  
  protected void a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!TextUtils.isEmpty(str)) {
      bgqv.c.put(this.jdField_a_of_type_JavaLangString, str);
    }
  }
  
  public void a(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131559913, null);
    setContentView(paramActivity);
    a(paramActivity);
    a();
    super.show();
    paramActivity = getWindow().getAttributes();
    paramActivity.x = 0;
    paramActivity.y = 0;
    paramActivity.width = -1;
    paramActivity.windowAnimations = 16973824;
    paramActivity.gravity = 83;
    paramActivity.softInputMode = 21;
    getWindow().setBackgroundDrawable(new ColorDrawable());
    if (QLog.isColorLevel()) {
      QLog.d("PublicCommentPopupWindow", 2, "PublicCommentWindow show time = " + (System.currentTimeMillis() - l));
    }
  }
  
  /* Error */
  protected void a(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 179
    //   3: invokevirtual 185	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 187
    //   11: invokevirtual 185	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 189	bfgj:c	Ljava/lang/String;
    //   17: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 156
    //   25: iconst_2
    //   26: new 158	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   33: ldc 191
    //   35: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 193	org/json/JSONObject
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 196	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: putfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   65: ldc 200
    //   67: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 72	bfgj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: ldc 205
    //   80: invokevirtual 209	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: putfield 211	bfgj:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   91: ldc 213
    //   93: invokevirtual 209	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: putfield 215	bfgj:jdField_b_of_type_Int	I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   104: ldc 217
    //   106: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 219	bfgj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: aload_0
    //   113: new 221	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 222	java/util/ArrayList:<init>	()V
    //   120: putfield 224	bfgj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: aload_0
    //   124: getfield 198	bfgj:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ldc 226
    //   129: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 232	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 224	bfgj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 235	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokevirtual 239	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_0
    //   149: new 241	bfgk
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 244	bfgk:<init>	(Lbfgj;)V
    //   157: putfield 246	bfgj:jdField_a_of_type_Bfgk	Lbfgk;
    //   160: new 248	android/content/IntentFilter
    //   163: dup
    //   164: ldc 250
    //   166: invokespecial 251	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 40	bfgj:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   174: aload_0
    //   175: getfield 246	bfgj:jdField_a_of_type_Bfgk	Lbfgk;
    //   178: aload_1
    //   179: invokevirtual 257	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   182: pop
    //   183: return
    //   184: astore_1
    //   185: aload_0
    //   186: invokevirtual 260	bfgj:dismiss	()V
    //   189: return
    //   190: astore_1
    //   191: aload_0
    //   192: invokevirtual 260	bfgj:dismiss	()V
    //   195: return
    //   196: astore_1
    //   197: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq -52 -> 148
    //   203: ldc 156
    //   205: iconst_2
    //   206: aload_1
    //   207: invokestatic 264	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -65 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	bfgj
    //   0	216	1	paramBundle	Bundle
    //   6	48	2	str	String
    // Exception table:
    //   from	to	target	type
    //   48	60	184	org/json/JSONException
    //   48	60	190	java/lang/NullPointerException
    //   123	148	196	java/lang/NullPointerException
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131376925));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365923));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368725));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377324));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131369677));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131379291).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(asmu paramasmu)
  {
    paramasmu.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  protected void a(String paramString)
  {
    try
    {
      awgm.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.a(paramString, null, null)), this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof binz)))
    {
      localObject = ((binz)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a();
      if (localObject != null)
      {
        localObject = ((WebViewFragment)localObject).getWebView();
        if (localObject != null)
        {
          if (!paramBoolean) {
            break label92;
          }
          ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramString2 + "}}" });
        }
      }
    }
    return;
    label92:
    ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":-1}" });
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        awgm.a("qbrowserCommentOnCreate", null, this.jdField_a_of_type_JavaUtilArrayList, null);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847906);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695588));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.jdField_b_of_type_Boolean));
    dismiss();
  }
  
  protected boolean a()
  {
    String str = (String)bgqv.c.get(this.jdField_a_of_type_JavaLangString);
    bgqv.c.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public boolean a(asmu paramasmu)
  {
    return false;
  }
  
  public void b()
  {
    behh.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(asmu paramasmu) {}
  
  public void c()
  {
    String str = bgqv.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if (i == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131695606, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i < this.jdField_b_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695604, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i > this.jdField_a_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695605, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!nnr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693936, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      a(str);
      return;
    }
  }
  
  public void d() {}
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bfgk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_Bfgk);
      this.jdField_a_of_type_Bfgk = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    awgm.a("qbrowserCommentOnClose", null, this.jdField_a_of_type_JavaUtilArrayList, null);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      continue;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
          blgx.a(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847906);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695588));
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
          blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicCommentWindow.1(this), 200L);
          continue;
          c();
        }
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgj
 * JD-Core Version:    0.7.0.1
 */