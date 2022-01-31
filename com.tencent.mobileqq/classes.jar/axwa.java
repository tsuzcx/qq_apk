import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axwa
  extends axun
{
  String S;
  String T;
  protected String U;
  protected String V;
  protected String W;
  public String X;
  public int k = 1;
  int l = 10;
  
  public axwa()
  {
    this(null);
  }
  
  public axwa(String paramString)
  {
    this(paramString, "tag");
  }
  
  public axwa(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.X = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramView.findViewById(2131367976);
      paramContext = (TextView)paramView.findViewById(2131378368);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.S)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.S));
        if (this.l > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.l);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.T))
        {
          localObject = new ColorDrawable(2131167087);
          localObject = URLDrawable.getDrawable(this.T, (Drawable)localObject, (Drawable)localObject);
          if (((URLDrawable)localObject).getStatus() != 1) {
            ((URLDrawable)localObject).restartDownload();
          }
          paramBundle.setImageDrawable((Drawable)localObject);
          paramBundle.setVisibility(0);
          if (TextUtils.isEmpty(this.X)) {
            break label465;
          }
          paramContext.setText(this.X);
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        try
        {
          paramContext.setTextColor(Color.parseColor(this.U));
        }
        catch (Exception paramBundle)
        {
          try
          {
            for (;;)
            {
              paramContext.setTextSize(Integer.parseInt(this.W));
              paramContext.setVisibility(0);
              return paramView;
              paramView = new LinearLayout(paramContext);
              paramView.setOrientation(0);
              paramView.setMinimumHeight(actn.a(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(actn.a(5.0F, (Resources)localObject), actn.a(2.0F, (Resources)localObject), actn.a(5.0F, (Resources)localObject), actn.a(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(actn.a(9.0F, (Resources)localObject), actn.a(9.0F, (Resources)localObject));
              paramBundle.setId(2131367976);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(actn.a(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131378368);
              paramView.addView(paramContext, localLayoutParams);
              break;
              localIllegalArgumentException = localIllegalArgumentException;
              if (QLog.isColorLevel())
              {
                QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml bgColor is not a color value.", localIllegalArgumentException);
                continue;
                paramBundle.setVisibility(8);
                continue;
                paramBundle = paramBundle;
                paramContext.setTextColor(b());
              }
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramContext.setTextSize(c());
            }
          }
        }
        label465:
        paramContext.setVisibility(8);
      }
    }
    return paramView;
  }
  
  public String a()
  {
    return "tag";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.U = axas.a(paramObjectInput.readUTF(), false);
    this.W = axas.a(paramObjectInput.readUTF(), false);
    this.X = axas.a(paramObjectInput.readUTF(), false);
    this.S = axas.a(paramObjectInput.readUTF(), false);
    this.T = axas.a(paramObjectInput.readUTF(), false);
    this.l = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.U == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.W != null) {
        break label116;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.X != null) {
        break label124;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.S != null) {
        break label136;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.T != null) {
        break label144;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.l > 0) {
        break label152;
      }
    }
    label136:
    label144:
    label152:
    for (int i = 10;; i = this.l)
    {
      paramObjectOutput.writeInt(i);
      return;
      str = this.U;
      break;
      label116:
      str = this.W;
      break label32;
      label124:
      str = axas.a(this.X, false);
      break label49;
      str = this.S;
      break label66;
      str = this.T;
      break label83;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (this.X != null)
    {
      if (!TextUtils.isEmpty(this.W)) {
        paramXmlSerializer.attribute(null, "size", this.W);
      }
      if (!TextUtils.isEmpty(this.U)) {
        paramXmlSerializer.attribute(null, "color", this.U);
      }
      if (!TextUtils.isEmpty(this.V)) {
        paramXmlSerializer.attribute(null, "style", this.V);
      }
      paramXmlSerializer.text(this.X);
      if (!TextUtils.isEmpty(this.S)) {
        paramXmlSerializer.attribute(null, "bgColor", this.S);
      }
      if (!TextUtils.isEmpty(this.T)) {
        paramXmlSerializer.attribute(null, "icon", this.T);
      }
      if (this.l > 0) {
        paramXmlSerializer.attribute(null, "radius", this.l + "");
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(axwe paramaxwe)
  {
    if (paramaxwe == null) {}
    do
    {
      return true;
      this.U = paramaxwe.a("color");
      this.V = paramaxwe.a("style");
      this.W = paramaxwe.a("size");
      this.X = axas.a(axuy.a(paramaxwe), false);
      this.S = paramaxwe.a("bgColor");
      this.T = paramaxwe.a("icon");
      paramaxwe = paramaxwe.a("radius");
      try
      {
        this.l = Integer.valueOf(paramaxwe).intValue();
        return true;
      }
      catch (NumberFormatException paramaxwe) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", paramaxwe);
    return true;
  }
  
  public int b()
  {
    return -1;
  }
  
  public int c()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwa
 * JD-Core Version:    0.7.0.1
 */