import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.LinkedList;
import java.util.List;

public class blop
  extends Dialog
  implements DialogInterface.OnShowListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, bloj
{
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blog jdField_a_of_type_Blog;
  private blor jdField_a_of_type_Blor;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public blop(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755053);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558528, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378986));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131364039));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131364043));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376101));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366432));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379493);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    setOnShowListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_Blog = new blog(paramContext, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Blog);
    this.jdField_a_of_type_Blog.a(bloh.a);
    if (paramInt == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private int a(int paramInt)
  {
    int j = this.jdField_a_of_type_Blog.getItemCount();
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= j - 1);
    return j - 1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Blog == null)) {}
    while (this.jdField_a_of_type_Blog.getItemCount() == 0) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new bloq(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  @NonNull
  public List<bloh> a()
  {
    if (this.jdField_a_of_type_Blog != null) {
      return this.jdField_a_of_type_Blog.a();
    }
    return new LinkedList();
  }
  
  public void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    paramInt = a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPosition(paramInt);
  }
  
  public void a(@NonNull bloh parambloh)
  {
    a(parambloh, 0, true);
  }
  
  public void a(@Nullable bloh parambloh, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Blor != null) {
        this.jdField_a_of_type_Blor.a(parambloh, paramInt);
      }
    } while ((this.jdField_a_of_type_AndroidWidgetCheckBox == null) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()));
    this.c = true;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void a(@Nullable blor paramblor)
  {
    this.jdField_a_of_type_Blor = paramblor;
  }
  
  public void a(@NonNull List<bloh> paramList)
  {
    if (this.jdField_a_of_type_Blog != null) {
      this.jdField_a_of_type_Blog.a(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      if (isShowing()) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Blor != null) {
      this.jdField_a_of_type_Blor.t();
    }
    b();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == 2131364039) {
      if (this.c) {
        this.c = false;
      }
    }
    while ((i != 2131364043) || (this.jdField_a_of_type_Blor == null))
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Blor == null);
      this.jdField_a_of_type_Blor.a(paramBoolean);
      return;
    }
    this.jdField_a_of_type_Blor.b(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131378986) {
      if (!bljm.a(paramView)) {}
    }
    while (i != 2131366432)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Blor == null);
      this.jdField_a_of_type_Blor.s();
      return;
    }
    dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.gravity = 81;
    if (this.jdField_a_of_type_Int != 0) {}
    for (paramBundle.height = this.jdField_a_of_type_Int;; paramBundle.height = -2)
    {
      paramBundle.width = -1;
      getWindow().setAttributes(paramBundle);
      setCancelable(true);
      setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
  }
  
  public void show()
  {
    super.show();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blop
 * JD-Core Version:    0.7.0.1
 */