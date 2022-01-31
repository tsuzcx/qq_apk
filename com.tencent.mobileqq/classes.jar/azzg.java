import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;

public class azzg
  extends azus
{
  public String S;
  private String T;
  private String U;
  public View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  
  public azzg()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azzh(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new azzi(this);
    this.jdField_a_of_type_JavaLangString = "pavideo";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramContext.getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView))) {
      paramView = (PAHighLightImageView)paramView;
    }
    for (;;)
    {
      paramView.setTag(this);
      try
      {
        paramBundle = paramBundle.getDrawable(2130841415);
        if (TextUtils.isEmpty(this.S))
        {
          paramView.setBackgroundDrawable(paramBundle);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          paramView = new PAHighLightImageView(paramContext);
          paramView.setId(2131368094);
          paramView.setContentDescription(paramBundle.getString(2131694906));
          paramView.setDisplayRuleDef(beop.a);
          paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramView.setContentDescription(paramBundle.getText(2131720350));
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        paramBundle = URLDrawable.getDrawable(this.S, i, i, paramBundle, paramBundle);
        if (baqn.b(this.S)) {
          break label191;
        }
      }
    }
    label191:
    boolean bool;
    if (!bayu.a(paramContext))
    {
      bool = true;
      label194:
      paramBundle.setAutoDownload(bool);
      if ((paramBundle == null) || (paramBundle.getStatus() != 1)) {
        break label231;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(paramBundle);
      break;
      bool = false;
      break label194;
      label231:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131377139) {
        return (StructMsgForGeneralShare)paramView.getTag(2131377139);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "pavideo";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
    this.T = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int > 5)
    {
      this.U = paramObjectInput.readUTF();
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S != null)
    {
      str = this.S;
      paramObjectOutput.writeUTF(str);
      if (this.T == null) {
        break label134;
      }
      str = this.T;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.U == null) {
          break label140;
        }
        str = this.U;
        label63:
        paramObjectOutput.writeUTF(str);
        if (this.j == null) {
          break label146;
        }
        str = this.j;
        label82:
        paramObjectOutput.writeUTF(str);
        if (this.k == null) {
          break label152;
        }
        str = this.k;
        label101:
        paramObjectOutput.writeUTF(str);
        if (this.l == null) {
          break label158;
        }
      }
    }
    label134:
    label140:
    label146:
    label152:
    label158:
    for (String str = this.l;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label63;
      str = "";
      break label82;
      str = "";
      break label101;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "pavideo");
    paramXmlSerializer.attribute(null, "cover", this.S);
    paramXmlSerializer.attribute(null, "src", this.T);
    if (this.jdField_a_of_type_Int > 5)
    {
      paramXmlSerializer.attribute(null, "video_info", this.U);
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        paramXmlSerializer.attribute(null, "index_name", this.k);
      }
      if (!TextUtils.isEmpty(this.l)) {
        paramXmlSerializer.attribute(null, "index_type", this.l);
      }
    }
    paramXmlSerializer.endTag(null, "pavideo");
  }
  
  public boolean a(azwj paramazwj)
  {
    if (paramazwj == null) {}
    do
    {
      return true;
      this.S = paramazwj.a("cover");
      this.T = paramazwj.a("src");
    } while (this.jdField_a_of_type_Int <= 5);
    this.U = paramazwj.a("video_info");
    this.j = paramazwj.a("index");
    this.k = paramazwj.a("index_name");
    this.l = paramazwj.a("index_type");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzg
 * JD-Core Version:    0.7.0.1
 */