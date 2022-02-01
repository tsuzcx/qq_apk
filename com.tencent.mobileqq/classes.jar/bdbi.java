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

public class bdbi
  extends bcvu
{
  public ArrayList<bdbj> a;
  public int o;
  public int p;
  public int q;
  
  public bdbi()
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
      paramView.setId(2131379561);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130850456);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.ad)) {
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
    bdbj localbdbj;
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
        localbdbj = (bdbj)paramBundle.get(j);
        if (localbdbj != null) {
          break;
        }
        j += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      i = Integer.parseInt(this.ad);
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
      localTextView.setText(" " + localbdbj.b);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(new bdbj(this, str1, str2));
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
        bdbj localbdbj = (bdbj)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localbdbj != null)
        {
          if (localbdbj.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localbdbj.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localbdbj.b)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = localbdbj.jdField_a_of_type_JavaLangString;
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
        bdbj localbdbj = (bdbj)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localbdbj != null)
        {
          paramXmlSerializer.startTag(null, localbdbj.jdField_a_of_type_JavaLangString);
          if (localbdbj.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localbdbj.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localbdbj.jdField_a_of_type_JavaLangString);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {}
    for (;;)
    {
      return true;
      Object localObject = parambcxj.a("min");
      String str = parambcxj.a("max");
      try
      {
        this.p = Integer.parseInt((String)localObject);
        this.o = Integer.parseInt(str);
        this.q = parambcxj.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.q);
        int i = 0;
        while (i < this.q)
        {
          localObject = parambcxj.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new bdbj(this, (bcxj)localObject));
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
    return 2131380008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbi
 * JD-Core Version:    0.7.0.1
 */