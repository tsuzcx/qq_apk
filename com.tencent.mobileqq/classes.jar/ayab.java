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

public class ayab
  extends axur
{
  public ArrayList<ayac> a;
  public int k;
  public int l;
  public int m;
  
  public ayab()
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
      paramView.setId(2131378092);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130849362);
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
    ayac localayac;
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
        localayac = (ayac)paramBundle.get(j);
        if (localayac != null) {
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
      localTextView.setText(" " + localayac.b);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(new ayac(this, str1, str2));
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
        ayac localayac = (ayac)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localayac != null)
        {
          if (localayac.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localayac.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localayac.b)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = localayac.jdField_a_of_type_JavaLangString;
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
        ayac localayac = (ayac)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localayac != null)
        {
          paramXmlSerializer.startTag(null, localayac.jdField_a_of_type_JavaLangString);
          if (localayac.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localayac.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localayac.jdField_a_of_type_JavaLangString);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(axwg paramaxwg)
  {
    if (paramaxwg == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramaxwg.a("min");
      String str = paramaxwg.a("max");
      try
      {
        this.l = Integer.parseInt((String)localObject);
        this.k = Integer.parseInt(str);
        this.m = paramaxwg.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.m);
        int i = 0;
        while (i < this.m)
        {
          localObject = paramaxwg.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new ayac(this, (axwg)localObject));
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
    return 2131378418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayab
 * JD-Core Version:    0.7.0.1
 */