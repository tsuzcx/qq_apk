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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bdph
  extends bdnu
{
  String ac;
  String ad;
  protected String ae;
  protected String af;
  protected String ag;
  public String ah;
  public int o = 1;
  int p = 10;
  
  public bdph()
  {
    this(null);
  }
  
  public bdph(String paramString)
  {
    this(paramString, "tag");
  }
  
  public bdph(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.ah = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramView.findViewById(2131368706);
      paramContext = (TextView)paramView.findViewById(2131380195);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.ac)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.ac));
        if (this.p > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.p);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.ad))
        {
          localObject = new ColorDrawable(2131167296);
          localObject = URLDrawable.getDrawable(this.ad, (Drawable)localObject, (Drawable)localObject);
          if (((URLDrawable)localObject).getStatus() != 1) {
            ((URLDrawable)localObject).restartDownload();
          }
          paramBundle.setImageDrawable((Drawable)localObject);
          paramBundle.setVisibility(0);
          if (TextUtils.isEmpty(this.ah)) {
            break label465;
          }
          paramContext.setText(this.ah);
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        try
        {
          paramContext.setTextColor(Color.parseColor(this.ae));
        }
        catch (Exception paramBundle)
        {
          try
          {
            for (;;)
            {
              paramContext.setTextSize(Integer.parseInt(this.ag));
              paramContext.setVisibility(0);
              return paramView;
              paramView = new LinearLayout(paramContext);
              paramView.setOrientation(0);
              paramView.setMinimumHeight(AIOUtils.dp2px(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(AIOUtils.dp2px(5.0F, (Resources)localObject), AIOUtils.dp2px(2.0F, (Resources)localObject), AIOUtils.dp2px(5.0F, (Resources)localObject), AIOUtils.dp2px(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.dp2px(9.0F, (Resources)localObject), AIOUtils.dp2px(9.0F, (Resources)localObject));
              paramBundle.setId(2131368706);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(AIOUtils.dp2px(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131380195);
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
    this.ae = bcsc.a(paramObjectInput.readUTF(), false);
    this.ag = bcsc.a(paramObjectInput.readUTF(), false);
    this.ah = bcsc.a(paramObjectInput.readUTF(), false);
    this.ac = bcsc.a(paramObjectInput.readUTF(), false);
    this.ad = bcsc.a(paramObjectInput.readUTF(), false);
    this.p = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.ae == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ag != null) {
        break label116;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.ah != null) {
        break label124;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.ac != null) {
        break label136;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.ad != null) {
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
      str = this.ae;
      break;
      label116:
      str = this.ag;
      break label32;
      label124:
      str = bcsc.a(this.ah, false);
      break label49;
      str = this.ac;
      break label66;
      str = this.ad;
      break label83;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (this.ah != null)
    {
      if (!TextUtils.isEmpty(this.ag)) {
        paramXmlSerializer.attribute(null, "size", this.ag);
      }
      if (!TextUtils.isEmpty(this.ae)) {
        paramXmlSerializer.attribute(null, "color", this.ae);
      }
      if (!TextUtils.isEmpty(this.af)) {
        paramXmlSerializer.attribute(null, "style", this.af);
      }
      paramXmlSerializer.text(this.ah);
      if (!TextUtils.isEmpty(this.ac)) {
        paramXmlSerializer.attribute(null, "bgColor", this.ac);
      }
      if (!TextUtils.isEmpty(this.ad)) {
        paramXmlSerializer.attribute(null, "icon", this.ad);
      }
      if (this.p > 0) {
        paramXmlSerializer.attribute(null, "radius", this.p + "");
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(bdpl parambdpl)
  {
    if (parambdpl == null) {}
    do
    {
      return true;
      this.ae = parambdpl.a("color");
      this.af = parambdpl.a("style");
      this.ag = parambdpl.a("size");
      this.ah = bcsc.a(bdof.a(parambdpl), false);
      this.ac = parambdpl.a("bgColor");
      this.ad = parambdpl.a("icon");
      parambdpl = parambdpl.a("radius");
      try
      {
        this.p = Integer.valueOf(parambdpl).intValue();
        return true;
      }
      catch (NumberFormatException parambdpl) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", parambdpl);
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
 * Qualified Name:     bdph
 * JD-Core Version:    0.7.0.1
 */