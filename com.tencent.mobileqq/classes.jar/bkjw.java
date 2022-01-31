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

public class bkjw
  extends bkke
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<bkjz> jdField_a_of_type_JavaUtilList;
  
  public bkjw(Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull List<bkjz> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString1, paramString2, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bkka a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new bkka(null);
      ((bkka)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bkjz)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new bkka(null);
        ((bkka)localObject2).jdField_a_of_type_Int = 2;
        ((bkka)localObject2).jdField_a_of_type_Bkjz = ((bkjz)localObject1);
        return localObject2;
      }
      if (!bkjz.a((bkjz)localObject1)) {
        break label253;
      }
      if (paramInt <= ((bkjz)localObject1).a().size() + i)
      {
        localObject2 = (bkjy)((bkjz)localObject1).a().get(paramInt - i - 1);
        bkka localbkka = new bkka(null);
        localbkka.jdField_a_of_type_Int = 3;
        localbkka.jdField_a_of_type_Bkjz = ((bkjz)localObject1);
        localbkka.jdField_a_of_type_Bkjy = ((bkjy)localObject2);
        return localbkka;
      }
      i = ((bkjz)localObject1).a().size() + i;
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
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131363965);
    Object localObject = (ImageView)paramView.findViewById(2131363975);
    TextView localTextView = (TextView)paramView.findViewById(2131363972);
    paramView = paramView.findViewById(2131363966);
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
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = vzo.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
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
  
  private void a(View paramView, bkjz parambkjz)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367211);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367213);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367184);
    paramView = (CheckBox)paramView.findViewById(2131367186);
    localTextView1.setText(parambkjz.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(parambkjz.a()), Integer.valueOf(parambkjz.b()) }));
    if (parambkjz.b() == 0)
    {
      paramView.setVisibility(4);
      if (!parambkjz.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!bkjz.a(parambkjz)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new bkjx(this, parambkjz));
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
  
  private void a(View paramView, bkjz parambkjz, bkjy parambkjy)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131366785);
    Object localObject1 = (TextView)paramView.findViewById(2131366805);
    Object localObject2 = (CheckBox)paramView.findViewById(2131366768);
    paramView = paramView.findViewById(2131366767);
    ((TextView)localObject1).setText(parambkjy.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (parambkjy.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bbdr.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, parambkjy.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(parambkjz) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        parambkjz = parambkjz.a();
        if (parambkjz.indexOf(parambkjy) == parambkjz.size() - 1)
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
      veg.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      veg.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(bkka parambkka)
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
  
  private void b(bkka parambkka)
  {
    parambkka.jdField_a_of_type_Bkjz.a();
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
      bkjz localbkjz = (bkjz)localIterator.next();
      List localList = localbkjz.a();
      i += 1;
      if (!bkjz.a(localbkjz)) {
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
  
  private void c(bkka parambkka)
  {
    parambkka.jdField_a_of_type_Bkjz.a(parambkka.jdField_a_of_type_Bkjy);
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
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561314, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561316, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561315, null);
  }
  
  @NonNull
  public List<bkjy> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bkjz)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    bkka localbkka = a(paramInt);
    switch (localbkka.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localbkka);
      return;
    case 2: 
      b(localbkka);
      return;
    }
    c(localbkka);
  }
  
  public void a(int paramInt, View paramView)
  {
    bkka localbkka = a(paramInt);
    switch (localbkka.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localbkka.jdField_a_of_type_Bkjz);
      return;
    }
    a(paramView, localbkka.jdField_a_of_type_Bkjz, localbkka.jdField_a_of_type_Bkjy);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      bkjz localbkjz = (bkjz)localIterator1.next();
      Iterator localIterator2 = localbkjz.a().iterator();
      while (localIterator2.hasNext())
      {
        bkjy localbkjy = (bkjy)localIterator2.next();
        if (paramList.contains(localbkjy.a())) {
          localbkjz.b(localbkjy);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkjw
 * JD-Core Version:    0.7.0.1
 */