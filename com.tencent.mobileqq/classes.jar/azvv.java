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

public class azvv
  extends azql
{
  public ArrayList<azvw> a;
  public int k;
  public int l;
  public int m;
  
  public azvv()
  {
    this.jdField_a_of_type_JavaLangString = "checklist";
    c("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Drawable localDrawable;
    int i;
    label75:
    int n;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131378645);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130849795);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.V)) {
        break label184;
      }
      i = f();
      n = i / 2;
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
    azvw localazvw;
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
        localazvw = (azvw)paramBundle.get(j);
        if (localazvw != null) {
          break;
        }
        j += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      i = Integer.parseInt(this.V);
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
      localTextView.setTextSize(n);
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      localTextView.setText(" " + localazvw.b);
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
    this.l = paramObjectInput.readInt();
    this.k = paramObjectInput.readInt();
    this.m = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.m);
    int i = 0;
    while (i < this.m)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.jdField_a_of_type_JavaUtilArrayList.add(new azvw(this, str1, str2));
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.l);
    paramObjectOutput.writeInt(this.k);
    paramObjectOutput.writeInt(this.m);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.m))
    {
      int i = 0;
      if (i < this.m)
      {
        azvw localazvw = (azvw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localazvw != null)
        {
          if (localazvw.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localazvw.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localazvw.b)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = localazvw.jdField_a_of_type_JavaLangString;
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
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.k));
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        azvw localazvw = (azvw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localazvw != null)
        {
          paramXmlSerializer.startTag(null, localazvw.jdField_a_of_type_JavaLangString);
          if (localazvw.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localazvw.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localazvw.jdField_a_of_type_JavaLangString);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(azsa paramazsa)
  {
    if (paramazsa == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramazsa.a("min");
      String str = paramazsa.a("max");
      try
      {
        this.l = Integer.parseInt((String)localObject);
        this.k = Integer.parseInt(str);
        this.m = paramazsa.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.m);
        int i = 0;
        while (i < this.m)
        {
          localObject = paramazsa.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new azvw(this, (azsa)localObject));
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
    return 2131379030;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvv
 * JD-Core Version:    0.7.0.1
 */