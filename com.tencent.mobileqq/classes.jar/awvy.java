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

public class awvy
  extends awul
{
  String S;
  String T;
  protected String U;
  protected String V;
  protected String W;
  public String X;
  public int i = 1;
  int j = 10;
  
  public awvy()
  {
    this(null);
  }
  
  public awvy(String paramString)
  {
    this(paramString, "tag");
  }
  
  public awvy(String paramString1, String paramString2)
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
      paramBundle = (URLImageView)paramView.findViewById(2131302356);
      paramContext = (TextView)paramView.findViewById(2131312543);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.S)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.S));
        if (this.j > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.j);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.T))
        {
          localObject = new ColorDrawable(2131101491);
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
              paramView.setMinimumHeight(aciy.a(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(aciy.a(5.0F, (Resources)localObject), aciy.a(2.0F, (Resources)localObject), aciy.a(5.0F, (Resources)localObject), aciy.a(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aciy.a(9.0F, (Resources)localObject), aciy.a(9.0F, (Resources)localObject));
              paramBundle.setId(2131302356);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(aciy.a(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131312543);
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
    this.U = awbk.a(paramObjectInput.readUTF(), false);
    this.W = awbk.a(paramObjectInput.readUTF(), false);
    this.X = awbk.a(paramObjectInput.readUTF(), false);
    this.S = awbk.a(paramObjectInput.readUTF(), false);
    this.T = awbk.a(paramObjectInput.readUTF(), false);
    this.j = paramObjectInput.readInt();
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
      if (this.j > 0) {
        break label152;
      }
    }
    label136:
    label144:
    label152:
    for (int k = 10;; k = this.j)
    {
      paramObjectOutput.writeInt(k);
      return;
      str = this.U;
      break;
      label116:
      str = this.W;
      break label32;
      label124:
      str = awbk.a(this.X, false);
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
      if (this.j > 0) {
        paramXmlSerializer.attribute(null, "radius", this.j + "");
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {}
    do
    {
      return true;
      this.U = paramawwc.a("color");
      this.V = paramawwc.a("style");
      this.W = paramawwc.a("size");
      this.X = awbk.a(awuw.a(paramawwc), false);
      this.S = paramawwc.a("bgColor");
      this.T = paramawwc.a("icon");
      paramawwc = paramawwc.a("radius");
      try
      {
        this.j = Integer.valueOf(paramawwc).intValue();
        return true;
      }
      catch (NumberFormatException paramawwc) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", paramawwc);
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
 * Qualified Name:     awvy
 * JD-Core Version:    0.7.0.1
 */