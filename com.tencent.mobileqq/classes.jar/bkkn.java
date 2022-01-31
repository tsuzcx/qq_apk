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

public class bkkn
  extends bkkv
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<bkkq> jdField_a_of_type_JavaUtilList;
  
  public bkkn(Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull List<bkkq> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString1, paramString2, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bkkr a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new bkkr(null);
      ((bkkr)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bkkq)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new bkkr(null);
        ((bkkr)localObject2).jdField_a_of_type_Int = 2;
        ((bkkr)localObject2).jdField_a_of_type_Bkkq = ((bkkq)localObject1);
        return localObject2;
      }
      if (!bkkq.a((bkkq)localObject1)) {
        break label253;
      }
      if (paramInt <= ((bkkq)localObject1).a().size() + i)
      {
        localObject2 = (bkkp)((bkkq)localObject1).a().get(paramInt - i - 1);
        bkkr localbkkr = new bkkr(null);
        localbkkr.jdField_a_of_type_Int = 3;
        localbkkr.jdField_a_of_type_Bkkq = ((bkkq)localObject1);
        localbkkr.jdField_a_of_type_Bkkp = ((bkkp)localObject2);
        return localbkkr;
      }
      i = ((bkkq)localObject1).a().size() + i;
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
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131363964);
    Object localObject = (ImageView)paramView.findViewById(2131363974);
    TextView localTextView = (TextView)paramView.findViewById(2131363971);
    paramView = paramView.findViewById(2131363965);
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
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
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
  
  private void a(View paramView, bkkq parambkkq)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367211);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367213);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367184);
    paramView = (CheckBox)paramView.findViewById(2131367186);
    localTextView1.setText(parambkkq.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(parambkkq.a()), Integer.valueOf(parambkkq.b()) }));
    if (parambkkq.b() == 0)
    {
      paramView.setVisibility(4);
      if (!parambkkq.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!bkkq.a(parambkkq)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new bkko(this, parambkkq));
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
  
  private void a(View paramView, bkkq parambkkq, bkkp parambkkp)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131366785);
    Object localObject1 = (TextView)paramView.findViewById(2131366805);
    Object localObject2 = (CheckBox)paramView.findViewById(2131366768);
    paramView = paramView.findViewById(2131366767);
    ((TextView)localObject1).setText(parambkkp.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (parambkkp.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bbef.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, parambkkp.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(parambkkq) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        parambkkq = parambkkq.a();
        if (parambkkq.indexOf(parambkkp) == parambkkq.size() - 1)
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
      ved.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      ved.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(bkkr parambkkr)
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
  
  private void b(bkkr parambkkr)
  {
    parambkkr.jdField_a_of_type_Bkkq.a();
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
      bkkq localbkkq = (bkkq)localIterator.next();
      List localList = localbkkq.a();
      i += 1;
      if (!bkkq.a(localbkkq)) {
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
  
  private void c(bkkr parambkkr)
  {
    parambkkr.jdField_a_of_type_Bkkq.a(parambkkr.jdField_a_of_type_Bkkp);
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
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561313, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561315, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561314, null);
  }
  
  @NonNull
  public List<bkkp> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bkkq)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    bkkr localbkkr = a(paramInt);
    switch (localbkkr.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localbkkr);
      return;
    case 2: 
      b(localbkkr);
      return;
    }
    c(localbkkr);
  }
  
  public void a(int paramInt, View paramView)
  {
    bkkr localbkkr = a(paramInt);
    switch (localbkkr.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localbkkr.jdField_a_of_type_Bkkq);
      return;
    }
    a(paramView, localbkkr.jdField_a_of_type_Bkkq, localbkkr.jdField_a_of_type_Bkkp);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      bkkq localbkkq = (bkkq)localIterator1.next();
      Iterator localIterator2 = localbkkq.a().iterator();
      while (localIterator2.hasNext())
      {
        bkkp localbkkp = (bkkp)localIterator2.next();
        if (paramList.contains(localbkkp.a())) {
          localbkkq.b(localbkkp);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkn
 * JD-Core Version:    0.7.0.1
 */