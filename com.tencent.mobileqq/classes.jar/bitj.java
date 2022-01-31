import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bitj
  extends bitr
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<bitm> jdField_a_of_type_JavaUtilList;
  
  public bitj(Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull List<bitm> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString1, paramString2, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bitn a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new bitn(null);
      ((bitn)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bitm)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new bitn(null);
        ((bitn)localObject2).jdField_a_of_type_Int = 2;
        ((bitn)localObject2).jdField_a_of_type_Bitm = ((bitm)localObject1);
        return localObject2;
      }
      if (!bitm.a((bitm)localObject1)) {
        break label253;
      }
      if (paramInt <= ((bitm)localObject1).a().size() + i)
      {
        localObject2 = (bitl)((bitm)localObject1).a().get(paramInt - i - 1);
        bitn localbitn = new bitn(null);
        localbitn.jdField_a_of_type_Int = 3;
        localbitn.jdField_a_of_type_Bitm = ((bitm)localObject1);
        localbitn.jdField_a_of_type_Bitl = ((bitl)localObject2);
        return localbitn;
      }
      i = ((bitm)localObject1).a().size() + i;
    }
    label253:
    for (;;)
    {
      break;
      throw new IllegalStateException("can not find item with innerPos:" + paramInt);
    }
  }
  
  private void a(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131298409);
    Object localObject = (ImageView)paramView.findViewById(2131298419);
    TextView localTextView = (TextView)paramView.findViewById(2131298416);
    paramView = paramView.findViewById(2131298410);
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ((ImageView)localObject).setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (!this.b) {
        break label138;
      }
      localCheckBox.setChecked(true);
    }
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = vms.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        i = -16444373;
      }
      paramView.setBackgroundColor(i);
      return;
      ((ImageView)localObject).setVisibility(4);
      break;
      label138:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, bitm parambitm)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131301599);
    TextView localTextView2 = (TextView)paramView.findViewById(2131301601);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131301572);
    paramView = (CheckBox)paramView.findViewById(2131301574);
    localTextView1.setText(parambitm.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(parambitm.a()), Integer.valueOf(parambitm.b()) }));
    if (parambitm.b() == 0)
    {
      paramView.setVisibility(4);
      if (!parambitm.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!bitm.a(parambitm)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new bitk(this, parambitm));
      return;
      paramView.setVisibility(0);
      break;
      label146:
      paramView.setChecked(false);
      break label111;
      label154:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, bitm parambitm, bitl parambitl)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131301175);
    Object localObject1 = (TextView)paramView.findViewById(2131301195);
    Object localObject2 = (CheckBox)paramView.findViewById(2131301158);
    paramView = paramView.findViewById(2131301157);
    ((TextView)localObject1).setText(parambitl.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (parambitl.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bacm.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, parambitl.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(parambitm) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        parambitm = parambitm.a();
        if (parambitm.indexOf(parambitl) == parambitm.size() - 1)
        {
          int i = -2170912;
          QQStoryContext.a();
          if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
            i = -16444373;
          }
          paramView.setBackgroundColor(i);
          paramView.setVisibility(0);
        }
      }
      return;
      ((CheckBox)localObject2).setChecked(false);
      break;
      label207:
      urk.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      urk.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(bitn parambitn)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean) {
      if (!this.b) {
        bool = true;
      }
    }
    for (this.b = bool;; this.b = true)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  private void b(bitn parambitn)
  {
    parambitn.jdField_a_of_type_Bitm.a();
  }
  
  private int c()
  {
    if (!this.b) {
      return 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      bitm localbitm = (bitm)localIterator.next();
      List localList = localbitm.a();
      i += 1;
      if (!bitm.a(localbitm)) {
        break label72;
      }
      i = localList.size() + i;
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c(bitn parambitn)
  {
    parambitn.jdField_a_of_type_Bitm.a(parambitn.jdField_a_of_type_Bitl);
  }
  
  public int a()
  {
    return c();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt).jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495723, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495725, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495724, null);
  }
  
  @NonNull
  public List<bitl> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bitm)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    bitn localbitn = a(paramInt);
    switch (localbitn.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localbitn);
      return;
    case 2: 
      b(localbitn);
      return;
    }
    c(localbitn);
  }
  
  public void a(int paramInt, View paramView)
  {
    bitn localbitn = a(paramInt);
    switch (localbitn.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localbitn.jdField_a_of_type_Bitm);
      return;
    }
    a(paramView, localbitn.jdField_a_of_type_Bitm, localbitn.jdField_a_of_type_Bitl);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      bitm localbitm = (bitm)localIterator1.next();
      Iterator localIterator2 = localbitm.a().iterator();
      while (localIterator2.hasNext())
      {
        bitl localbitl = (bitl)localIterator2.next();
        if (paramList.contains(localbitl.a())) {
          localbitm.b(localbitl);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitj
 * JD-Core Version:    0.7.0.1
 */