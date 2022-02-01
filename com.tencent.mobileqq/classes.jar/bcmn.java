import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class bcmn
  extends bcgy
{
  public ArrayList<bcmo> a;
  public int o;
  public int p;
  public int q;
  
  public bcmn()
  {
    this.jdField_a_of_type_JavaLangString = "checklist";
    c("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Drawable localDrawable;
    int i;
    label75:
    int k;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131379517);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130850394);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.af)) {
        break label184;
      }
      i = f();
      k = i / 2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != paramView.getChildCount()) {
        break label196;
      }
      i = 1;
      label98:
      if ((i == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 2) {
        break label202;
      }
    }
    int j;
    bcmo localbcmo;
    label184:
    label196:
    label202:
    for (paramBundle = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);; paramBundle = this.jdField_a_of_type_JavaUtilArrayList)
    {
      j = 0;
      for (;;)
      {
        if (j >= paramBundle.size()) {
          break label320;
        }
        localbcmo = (bcmo)paramBundle.get(j);
        if (localbcmo != null) {
          break;
        }
        j += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      i = Integer.parseInt(this.af);
      break label75;
      i = 0;
      break label98;
    }
    if (i != 0) {}
    for (TextView localTextView = (TextView)paramView.getChildAt(j);; localTextView = new TextView(paramContext))
    {
      localTextView.setSingleLine();
      localTextView.setEllipsize(a());
      localTextView.setGravity(16);
      localTextView.setTextSize(k);
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      localTextView.setText(" " + localbcmo.b);
      if (i != 0) {
        break;
      }
      paramView.addView(localTextView);
      break;
    }
    label320:
    paramView.setTag(this);
    return paramView;
  }
  
  public String a()
  {
    return "Vote";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.p = paramObjectInput.readInt();
    this.o = paramObjectInput.readInt();
    this.q = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.q);
    int i = 0;
    while (i < this.q)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.jdField_a_of_type_JavaUtilArrayList.add(new bcmo(this, str1, str2));
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.p);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.q);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.q))
    {
      int i = 0;
      if (i < this.q)
      {
        bcmo localbcmo = (bcmo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localbcmo != null)
        {
          if (localbcmo.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localbcmo.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localbcmo.b)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = localbcmo.jdField_a_of_type_JavaLangString;
          break label95;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "checklist");
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.o));
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bcmo localbcmo = (bcmo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localbcmo != null)
        {
          paramXmlSerializer.startTag(null, localbcmo.jdField_a_of_type_JavaLangString);
          if (localbcmo.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localbcmo.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localbcmo.jdField_a_of_type_JavaLangString);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(bcin parambcin)
  {
    if (parambcin == null) {}
    for (;;)
    {
      return true;
      Object localObject = parambcin.a("min");
      String str = parambcin.a("max");
      try
      {
        this.p = Integer.parseInt((String)localObject);
        this.o = Integer.parseInt(str);
        this.q = parambcin.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.q);
        int i = 0;
        while (i < this.q)
        {
          localObject = parambcin.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new bcmo(this, (bcin)localObject));
          }
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  protected int c()
  {
    return 2131379924;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmn
 * JD-Core Version:    0.7.0.1
 */