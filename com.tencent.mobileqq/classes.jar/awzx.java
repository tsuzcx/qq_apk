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

public class awzx
  extends awun
{
  public ArrayList<awzy> a;
  public int i;
  public int j;
  public int k;
  
  public awzx()
  {
    this.jdField_a_of_type_JavaLangString = "checklist";
    c("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Drawable localDrawable;
    int m;
    label75:
    int i1;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131312269);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130849118);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.V)) {
        break label184;
      }
      m = f();
      i1 = m / 2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != paramView.getChildCount()) {
        break label196;
      }
      m = 1;
      label98:
      if ((m == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 2) {
        break label202;
      }
    }
    int n;
    awzy localawzy;
    label184:
    label196:
    label202:
    for (paramBundle = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);; paramBundle = this.jdField_a_of_type_JavaUtilArrayList)
    {
      n = 0;
      for (;;)
      {
        if (n >= paramBundle.size()) {
          break label320;
        }
        localawzy = (awzy)paramBundle.get(n);
        if (localawzy != null) {
          break;
        }
        n += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      m = Integer.parseInt(this.V);
      break label75;
      m = 0;
      break label98;
    }
    if (m != 0) {}
    for (TextView localTextView = (TextView)paramView.getChildAt(n);; localTextView = new TextView(paramContext))
    {
      localTextView.setSingleLine();
      localTextView.setEllipsize(a());
      localTextView.setGravity(16);
      localTextView.setTextSize(i1);
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      localTextView.setText(" " + localawzy.b);
      if (m != 0) {
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
    this.j = paramObjectInput.readInt();
    this.i = paramObjectInput.readInt();
    this.k = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.k);
    int m = 0;
    while (m < this.k)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.jdField_a_of_type_JavaUtilArrayList.add(new awzy(this, str1, str2));
      m += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.j);
    paramObjectOutput.writeInt(this.i);
    paramObjectOutput.writeInt(this.k);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.k))
    {
      int m = 0;
      if (m < this.k)
      {
        awzy localawzy = (awzy)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if (localawzy != null)
        {
          if (localawzy.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localawzy.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localawzy.b)
        {
          paramObjectOutput.writeUTF(str);
          m += 1;
          break;
          label127:
          str = localawzy.jdField_a_of_type_JavaLangString;
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
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.j));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.i));
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int m = 0;
      if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        awzy localawzy = (awzy)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if (localawzy != null)
        {
          paramXmlSerializer.startTag(null, localawzy.jdField_a_of_type_JavaLangString);
          if (localawzy.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localawzy.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localawzy.jdField_a_of_type_JavaLangString);
          m += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramawwc.a("min");
      String str = paramawwc.a("max");
      try
      {
        this.j = Integer.parseInt((String)localObject);
        this.i = Integer.parseInt(str);
        this.k = paramawwc.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.k);
        int m = 0;
        while (m < this.k)
        {
          localObject = paramawwc.a(m);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new awzy(this, (awwc)localObject));
          }
          m += 1;
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
    return 2131312589;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzx
 * JD-Core Version:    0.7.0.1
 */