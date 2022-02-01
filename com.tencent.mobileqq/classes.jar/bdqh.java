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

public class bdqh
  extends bdol
{
  public String ac;
  public String ad;
  public int o;
  
  public bdqh()
  {
    this.a = "head";
  }
  
  public bdqh(int paramInt, String paramString1, String paramString2)
  {
    this();
    this.o = paramInt;
    this.ac = paramString1;
    this.ad = paramString2;
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
      localObject1 = (ImageView)localLinearLayout.findViewById(2131379697);
      paramBundle = (ImageView)localLinearLayout.findViewById(2131379700);
      paramView = (TextView)localLinearLayout.findViewById(2131379698);
      localObject3 = bhmq.a();
      localObject2 = localObject3;
      if ((paramContext instanceof BaseActivity)) {
        localObject2 = aoot.a(((BaseActivity)paramContext).app, 1, this.ac, 3, (Drawable)localObject3, (Drawable)localObject3);
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (paramBundle != null)
      {
        if (paramInt != 2) {
          break label594;
        }
        paramBundle.setImageResource(2130850452);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setText(this.ad);
        paramView.setTextSize(2, 20.0F);
        paramView.setTextColor(-1);
        paramView.setSingleLine();
        paramView.setEllipsize(TextUtils.TruncateAt.END);
      }
      return localLinearLayout;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setId(2131379699);
      localLinearLayout.setOrientation(1);
      if (this.o == 4)
      {
        i = 53;
        label193:
        if (this.o != 4) {
          break label406;
        }
      }
      label406:
      for (int j = 53;; j = 135)
      {
        i = paramBundle.getInt("bundle_args_cover_width", agej.a(i, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_cover_height", agej.a(j, (Resources)localObject2));
        paramView = new FrameLayout(paramContext);
        localObject1 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout.addView(paramView);
        if (paramInt != 4) {
          break label414;
        }
        i = paramBundle.getInt("bundle_args_avatar_width", agej.a(50.0F, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_avatar_height", agej.a(50.0F, (Resources)localObject2));
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setId(2131379697);
        paramBundle = new FrameLayout.LayoutParams(i, j);
        paramBundle.gravity = 17;
        paramView.addView((View)localObject1, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131379700);
        paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        paramView = null;
        break;
        i = 180;
        break label193;
      }
      label414:
      int i = paramBundle.getInt("bundle_args_avatar_width", agej.a(80.0F, (Resources)localObject2));
      j = paramBundle.getInt("bundle_args_avatar_height", agej.a(80.0F, (Resources)localObject2));
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131379697);
      paramBundle = new FrameLayout.LayoutParams(i, j);
      paramBundle.gravity = 17;
      paramView.addView((View)localObject1, paramBundle);
      paramBundle = new ImageView(paramContext);
      paramBundle.setId(2131379700);
      paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      paramView = new TextView(paramContext);
      paramView.setId(2131379698);
      localObject3 = new LinearLayout.LayoutParams(agej.a(180.0F, (Resources)localObject2), -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      ((LinearLayout.LayoutParams)localObject3).topMargin = agej.a(5.0F, (Resources)localObject2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramView.setGravity(1);
      localLinearLayout.addView(paramView);
      break;
      label594:
      if (paramInt == 1) {
        paramBundle.setImageResource(2130850454);
      } else if (paramInt == 3) {
        paramBundle.setImageResource(2130850453);
      } else if (paramInt == 4) {
        paramBundle.setImageResource(2130850451);
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, this.o, paramBundle);
  }
  
  public String a()
  {
    return "Avatar";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ad != null) {
        break label48;
      }
    }
    label48:
    for (String str = "";; str = this.ad)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.ac;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "head");
    if (this.ac == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uin", str);
      if (this.ad != null) {
        break label71;
      }
    }
    label71:
    for (String str = "";; str = this.ad)
    {
      paramXmlSerializer.attribute(null, "nick", str);
      paramXmlSerializer.endTag(null, "head");
      return;
      str = this.ac;
      break;
    }
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return false;
    }
    String str2 = parambdqc.a("uin");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ac = str1;
    str1 = parambdqc.a("nick");
    parambdqc = str1;
    if (str1 == null) {
      parambdqc = "";
    }
    this.ad = parambdqc;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqh
 * JD-Core Version:    0.7.0.1
 */