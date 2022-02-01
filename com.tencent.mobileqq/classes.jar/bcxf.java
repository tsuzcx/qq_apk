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

public class bcxf
  extends bcvs
{
  String aa;
  String ab;
  protected String ac;
  protected String ad;
  protected String ae;
  public String af;
  public int o = 1;
  int p = 10;
  
  public bcxf()
  {
    this(null);
  }
  
  public bcxf(String paramString)
  {
    this(paramString, "tag");
  }
  
  public bcxf(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.af = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramView.findViewById(2131368450);
      paramContext = (TextView)paramView.findViewById(2131379934);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.aa)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.aa));
        if (this.p > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.p);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.ab))
        {
          localObject = new ColorDrawable(2131167224);
          localObject = URLDrawable.getDrawable(this.ab, (Drawable)localObject, (Drawable)localObject);
          if (((URLDrawable)localObject).getStatus() != 1) {
            ((URLDrawable)localObject).restartDownload();
          }
          paramBundle.setImageDrawable((Drawable)localObject);
          paramBundle.setVisibility(0);
          if (TextUtils.isEmpty(this.af)) {
            break label465;
          }
          paramContext.setText(this.af);
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        try
        {
          paramContext.setTextColor(Color.parseColor(this.ac));
        }
        catch (Exception paramBundle)
        {
          try
          {
            for (;;)
            {
              paramContext.setTextSize(Integer.parseInt(this.ae));
              paramContext.setVisibility(0);
              return paramView;
              paramView = new LinearLayout(paramContext);
              paramView.setOrientation(0);
              paramView.setMinimumHeight(afur.a(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(afur.a(5.0F, (Resources)localObject), afur.a(2.0F, (Resources)localObject), afur.a(5.0F, (Resources)localObject), afur.a(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(afur.a(9.0F, (Resources)localObject), afur.a(9.0F, (Resources)localObject));
              paramBundle.setId(2131368450);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(afur.a(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131379934);
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
    this.ac = bbzj.a(paramObjectInput.readUTF(), false);
    this.ae = bbzj.a(paramObjectInput.readUTF(), false);
    this.af = bbzj.a(paramObjectInput.readUTF(), false);
    this.aa = bbzj.a(paramObjectInput.readUTF(), false);
    this.ab = bbzj.a(paramObjectInput.readUTF(), false);
    this.p = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.ac == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ae != null) {
        break label116;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.af != null) {
        break label124;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.aa != null) {
        break label136;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.ab != null) {
        break label144;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.p > 0) {
        break label152;
      }
    }
    label136:
    label144:
    label152:
    for (int i = 10;; i = this.p)
    {
      paramObjectOutput.writeInt(i);
      return;
      str = this.ac;
      break;
      label116:
      str = this.ae;
      break label32;
      label124:
      str = bbzj.a(this.af, false);
      break label49;
      str = this.aa;
      break label66;
      str = this.ab;
      break label83;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (this.af != null)
    {
      if (!TextUtils.isEmpty(this.ae)) {
        paramXmlSerializer.attribute(null, "size", this.ae);
      }
      if (!TextUtils.isEmpty(this.ac)) {
        paramXmlSerializer.attribute(null, "color", this.ac);
      }
      if (!TextUtils.isEmpty(this.ad)) {
        paramXmlSerializer.attribute(null, "style", this.ad);
      }
      paramXmlSerializer.text(this.af);
      if (!TextUtils.isEmpty(this.aa)) {
        paramXmlSerializer.attribute(null, "bgColor", this.aa);
      }
      if (!TextUtils.isEmpty(this.ab)) {
        paramXmlSerializer.attribute(null, "icon", this.ab);
      }
      if (this.p > 0) {
        paramXmlSerializer.attribute(null, "radius", this.p + "");
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {}
    do
    {
      return true;
      this.ac = parambcxj.a("color");
      this.ad = parambcxj.a("style");
      this.ae = parambcxj.a("size");
      this.af = bbzj.a(bcwd.a(parambcxj), false);
      this.aa = parambcxj.a("bgColor");
      this.ab = parambcxj.a("icon");
      parambcxj = parambcxj.a("radius");
      try
      {
        this.p = Integer.valueOf(parambcxj).intValue();
        return true;
      }
      catch (NumberFormatException parambcxj) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", parambcxj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxf
 * JD-Core Version:    0.7.0.1
 */