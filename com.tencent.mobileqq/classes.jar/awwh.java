import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class awwh
  extends awul
{
  public String S;
  public String T;
  public int i;
  
  public awwh()
  {
    this.a = "head";
  }
  
  public awwh(int paramInt, String paramString1, String paramString2)
  {
    this();
    this.i = paramInt;
    this.S = paramString1;
    this.T = paramString2;
  }
  
  public View a(Context paramContext, View paramView, int paramInt, Bundle paramBundle)
  {
    Object localObject2 = paramContext.getResources();
    LinearLayout localLinearLayout;
    Object localObject1;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = (ImageView)localLinearLayout.findViewById(2131312236);
      paramBundle = (ImageView)localLinearLayout.findViewById(2131312239);
      paramView = (TextView)localLinearLayout.findViewById(2131312237);
      localObject3 = bacm.a();
      localObject2 = localObject3;
      if ((paramContext instanceof BaseActivity)) {
        localObject2 = azwp.a(((BaseActivity)paramContext).app, 1, this.S, 3, (Drawable)localObject3, (Drawable)localObject3);
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (paramBundle != null)
      {
        if (paramInt != 2) {
          break label594;
        }
        paramBundle.setImageResource(2130849101);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setText(this.T);
        paramView.setTextSize(2, 20.0F);
        paramView.setTextColor(-1);
        paramView.setSingleLine();
        paramView.setEllipsize(TextUtils.TruncateAt.END);
      }
      return localLinearLayout;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setId(2131312238);
      localLinearLayout.setOrientation(1);
      if (this.i == 4)
      {
        j = 53;
        label193:
        if (this.i != 4) {
          break label406;
        }
      }
      label406:
      for (int k = 53;; k = 135)
      {
        j = paramBundle.getInt("bundle_args_cover_width", aciy.a(j, (Resources)localObject2));
        k = paramBundle.getInt("bundle_args_cover_height", aciy.a(k, (Resources)localObject2));
        paramView = new FrameLayout(paramContext);
        localObject1 = new LinearLayout.LayoutParams(j, k);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout.addView(paramView);
        if (paramInt != 4) {
          break label414;
        }
        j = paramBundle.getInt("bundle_args_avatar_width", aciy.a(50.0F, (Resources)localObject2));
        k = paramBundle.getInt("bundle_args_avatar_height", aciy.a(50.0F, (Resources)localObject2));
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setId(2131312236);
        paramBundle = new FrameLayout.LayoutParams(j, k);
        paramBundle.gravity = 17;
        paramView.addView((View)localObject1, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131312239);
        paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        paramView = null;
        break;
        j = 180;
        break label193;
      }
      label414:
      int j = paramBundle.getInt("bundle_args_avatar_width", aciy.a(80.0F, (Resources)localObject2));
      k = paramBundle.getInt("bundle_args_avatar_height", aciy.a(80.0F, (Resources)localObject2));
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131312236);
      paramBundle = new FrameLayout.LayoutParams(j, k);
      paramBundle.gravity = 17;
      paramView.addView((View)localObject1, paramBundle);
      paramBundle = new ImageView(paramContext);
      paramBundle.setId(2131312239);
      paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      paramView = new TextView(paramContext);
      paramView.setId(2131312237);
      localObject3 = new LinearLayout.LayoutParams(aciy.a(180.0F, (Resources)localObject2), -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      ((LinearLayout.LayoutParams)localObject3).topMargin = aciy.a(5.0F, (Resources)localObject2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramView.setGravity(1);
      localLinearLayout.addView(paramView);
      break;
      label594:
      if (paramInt == 1) {
        paramBundle.setImageResource(2130849103);
      } else if (paramInt == 3) {
        paramBundle.setImageResource(2130849102);
      } else if (paramInt == 4) {
        paramBundle.setImageResource(2130849100);
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, this.i, paramBundle);
  }
  
  public String a()
  {
    return "Avatar";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
    this.T = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.T != null) {
        break label48;
      }
    }
    label48:
    for (String str = "";; str = this.T)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.S;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "head");
    if (this.S == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uin", str);
      if (this.T != null) {
        break label71;
      }
    }
    label71:
    for (String str = "";; str = this.T)
    {
      paramXmlSerializer.attribute(null, "nick", str);
      paramXmlSerializer.endTag(null, "head");
      return;
      str = this.S;
      break;
    }
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {
      return false;
    }
    String str2 = paramawwc.a("uin");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.S = str1;
    str1 = paramawwc.a("nick");
    paramawwc = str1;
    if (str1 == null) {
      paramawwc = "";
    }
    this.T = paramawwc;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwh
 * JD-Core Version:    0.7.0.1
 */