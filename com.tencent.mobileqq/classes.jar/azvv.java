import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class azvv
  extends azus
{
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azvw(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public List<azus> a;
  
  public azvv()
  {
    this.jdField_a_of_type_JavaLangString = "group";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j;
    int i;
    label62:
    Object localObject;
    View localView;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setGravity(16);
      j = 0;
      i = 1;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label499;
      }
      paramView = (azus)this.jdField_a_of_type_JavaUtilList.get(j);
      localObject = paramView.jdField_a_of_type_JavaLangString;
      if (!"groupitem".equals(localObject)) {
        break label253;
      }
      localObject = paramView.a(paramContext, null, paramBundle);
      localView = ((View)localObject).findViewById(2131377124);
      if (localView != null)
      {
        if ((LinearLayout)((View)localObject).findViewById(2131377125) != null) {
          break label231;
        }
        localView.setOnClickListener(paramView);
        localView.setTag(paramView);
      }
      label155:
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.leftMargin = 0;
      paramView.rightMargin = 0;
      paramView.topMargin = 0;
      paramView.bottomMargin = 0;
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, paramView);
      this.jdField_a_of_type_AndroidUtilSparseArray.append(j, localObject);
    }
    for (;;)
    {
      j += 1;
      break label62;
      this.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      break;
      label231:
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(Integer.valueOf(j));
      break label155;
      label253:
      if ("hr".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        if (i != 0)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
          i = 0;
        }
        for (;;)
        {
          break;
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
      if ("title".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, aepi.a(50.0F, paramContext.getResources()));
        ((TextView)paramView).setGravity(16);
        ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(12.0F, paramContext.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
      else if ("item".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
    }
    label499:
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    return "group";
  }
  
  void a(azus paramazus)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramazus);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int m = paramObjectInput.readInt();
    int i = 1;
    int k = 0;
    if (k < m)
    {
      String str = paramObjectInput.readUTF();
      Object localObject;
      if ("item".equals(str)) {
        localObject = azvc.a(paramObjectInput.readInt());
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((azus)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((azus)localObject).a(paramObjectInput);
          if (("groupitem".equals(str)) || ("hr".equals(str)) || ("title".equals(str)) || ("item".equals(str))) {
            a((azus)localObject);
          }
        }
        k += 1;
        break;
        azus localazus = azvc.a(str);
        int j = i;
        if ("button".equals(str))
        {
          localazus.Q = String.valueOf(i);
          localazus.R = this.R;
          j = i + 1;
        }
        localObject = localazus;
        i = j;
        if (localazus != null)
        {
          localObject = localazus;
          i = j;
          if (azut.class.isInstance(localazus))
          {
            paramObjectInput.readInt();
            localObject = localazus;
            i = j;
          }
        }
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((azus)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "group");
    paramXmlSerializer.endTag(null, "group");
  }
  
  public boolean a(azwj paramazwj)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramazwj == null)
    {
      bool1 = true;
      return bool1;
    }
    int k = paramazwj.a();
    int i = 0;
    while (i < k)
    {
      azwj localazwj = paramazwj.a(i);
      if (localazwj == null)
      {
        label39:
        i += 1;
      }
      else
      {
        if ("item".equals(localazwj.b)) {}
        for (Object localObject = localazwj.a("layout");; localObject = azvc.a(localazwj.b))
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject)) {}
            for (int j = Integer.parseInt((String)localObject);; j = 0)
            {
              localObject = azvc.a(j);
              bool1 = bool2;
              if (localObject == null) {
                break;
              }
              bool1 = bool2;
              if (!((azus)localObject).a(localazwj)) {
                break;
              }
              a((azus)localObject);
              break label39;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (NumberFormatException paramazwj)
          {
            bool1 = bool2;
          }
          QLog.i("StructMsgGroupElement", 2, "Item layout value is " + 0);
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvv
 * JD-Core Version:    0.7.0.1
 */