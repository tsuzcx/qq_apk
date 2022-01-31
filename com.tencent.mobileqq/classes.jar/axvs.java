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

public class axvs
  extends axup
{
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axvt(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public List<axup> a;
  
  public axvs()
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
      paramView = (axup)this.jdField_a_of_type_JavaUtilList.get(j);
      localObject = paramView.jdField_a_of_type_JavaLangString;
      if (!"groupitem".equals(localObject)) {
        break label253;
      }
      localObject = paramView.a(paramContext, null, paramBundle);
      localView = ((View)localObject).findViewById(2131376570);
      if (localView != null)
      {
        if ((LinearLayout)((View)localObject).findViewById(2131376571) != null) {
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
        localObject = new LinearLayout.LayoutParams(-1, actj.a(50.0F, paramContext.getResources()));
        ((TextView)paramView).setGravity(16);
        ((LinearLayout.LayoutParams)localObject).leftMargin = actj.a(12.0F, paramContext.getResources());
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
  
  void a(axup paramaxup)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaxup);
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
        localObject = axuz.a(paramObjectInput.readInt());
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((axup)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((axup)localObject).a(paramObjectInput);
          if (("groupitem".equals(str)) || ("hr".equals(str)) || ("title".equals(str)) || ("item".equals(str))) {
            a((axup)localObject);
          }
        }
        k += 1;
        break;
        axup localaxup = axuz.a(str);
        int j = i;
        if ("button".equals(str))
        {
          localaxup.Q = String.valueOf(i);
          localaxup.R = this.R;
          j = i + 1;
        }
        localObject = localaxup;
        i = j;
        if (localaxup != null)
        {
          localObject = localaxup;
          i = j;
          if (axuq.class.isInstance(localaxup))
          {
            paramObjectInput.readInt();
            localObject = localaxup;
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
      ((axup)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "group");
    paramXmlSerializer.endTag(null, "group");
  }
  
  public boolean a(axwg paramaxwg)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramaxwg == null)
    {
      bool1 = true;
      return bool1;
    }
    int k = paramaxwg.a();
    int i = 0;
    while (i < k)
    {
      axwg localaxwg = paramaxwg.a(i);
      if (localaxwg == null)
      {
        label39:
        i += 1;
      }
      else
      {
        if ("item".equals(localaxwg.b)) {}
        for (Object localObject = localaxwg.a("layout");; localObject = axuz.a(localaxwg.b))
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject)) {}
            for (int j = Integer.parseInt((String)localObject);; j = 0)
            {
              localObject = axuz.a(j);
              bool1 = bool2;
              if (localObject == null) {
                break;
              }
              bool1 = bool2;
              if (!((axup)localObject).a(localaxwg)) {
                break;
              }
              a((axup)localObject);
              break label39;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (NumberFormatException paramaxwg)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvs
 * JD-Core Version:    0.7.0.1
 */