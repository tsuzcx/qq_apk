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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class azec
  extends Dialog
  implements View.OnClickListener, anyg, bcnj
{
  protected int a;
  protected long a;
  protected Handler a;
  protected Button a;
  protected EditText a;
  protected FrameLayout a;
  public ImageView a;
  protected azed a;
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
  
  public azec(BaseActivity paramBaseActivity, Bundle paramBundle)
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
      bajf.c.put(this.jdField_a_of_type_JavaLangString, str);
    }
  }
  
  public void a(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131559710, null);
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
    //   1: ldc 177
    //   3: invokevirtual 183	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 185
    //   11: invokevirtual 183	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 187	azec:c	Ljava/lang/String;
    //   17: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 154
    //   25: iconst_2
    //   26: new 156	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   33: ldc 189
    //   35: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 191	org/json/JSONObject
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 194	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: putfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   65: ldc 198
    //   67: invokevirtual 201	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 72	azec:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: ldc 203
    //   80: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: putfield 209	azec:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   91: ldc 211
    //   93: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: putfield 213	azec:jdField_b_of_type_Int	I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   104: ldc 215
    //   106: invokevirtual 201	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 217	azec:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: aload_0
    //   113: new 219	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 220	java/util/ArrayList:<init>	()V
    //   120: putfield 222	azec:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: aload_0
    //   124: getfield 196	azec:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ldc 224
    //   129: invokevirtual 201	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 230	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 222	azec:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 233	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_0
    //   149: new 239	azed
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 242	azed:<init>	(Lazec;)V
    //   157: putfield 244	azec:jdField_a_of_type_Azed	Lazed;
    //   160: new 246	android/content/IntentFilter
    //   163: dup
    //   164: ldc 248
    //   166: invokespecial 249	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 40	azec:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   174: aload_0
    //   175: getfield 244	azec:jdField_a_of_type_Azed	Lazed;
    //   178: aload_1
    //   179: invokevirtual 255	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   182: pop
    //   183: return
    //   184: astore_1
    //   185: aload_0
    //   186: invokevirtual 258	azec:dismiss	()V
    //   189: return
    //   190: astore_1
    //   191: aload_0
    //   192: invokevirtual 258	azec:dismiss	()V
    //   195: return
    //   196: astore_1
    //   197: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq -52 -> 148
    //   203: ldc 154
    //   205: iconst_2
    //   206: aload_1
    //   207: invokestatic 262	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -65 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	azec
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131375493));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365560));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368186));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375842));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131368945));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131377676).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(anyh paramanyh)
  {
    paramanyh.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  protected void a(String paramString)
  {
    try
    {
      armm.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.a(paramString, null, null)), this.jdField_a_of_type_JavaUtilArrayList, null);
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
    if ((!TextUtils.isEmpty(paramString1)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof bccs)))
    {
      localObject = ((bccs)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).b();
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
        armm.a("qbrowserCommentOnCreate", null, this.jdField_a_of_type_JavaUtilArrayList, null);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846988);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696543));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.jdField_b_of_type_Boolean));
    dismiss();
  }
  
  protected boolean a()
  {
    String str = (String)bajf.c.get(this.jdField_a_of_type_JavaLangString);
    bajf.c.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public boolean a(anyh paramanyh)
  {
    return false;
  }
  
  public void b()
  {
    aylc.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(anyh paramanyh) {}
  
  public void c()
  {
    String str = bajf.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if (i == 0)
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131696561, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i < this.jdField_b_of_type_Int)
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696559, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i > this.jdField_a_of_type_Int)
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696560, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!naj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694544, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      a(str);
      return;
    }
  }
  
  public void d() {}
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Azed != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_Azed);
      this.jdField_a_of_type_Azed = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    armm.a("qbrowserCommentOnClose", null, this.jdField_a_of_type_JavaUtilArrayList, null);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377676: 
    case 2131365560: 
      do
      {
        return;
        dismiss();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        bfni.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846988);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696543));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicCommentWindow.1(this), 200L);
      return;
    }
    c();
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azec
 * JD-Core Version:    0.7.0.1
 */