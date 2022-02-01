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
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.aeeditor.view.AEEditorMusicSwitchView;
import java.util.LinkedList;
import java.util.List;

public class bpja
  extends ReportDialog
  implements DialogInterface.OnShowListener, View.OnClickListener, bpiu
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private bpir jdField_a_of_type_Bpir;
  private bpje jdField_a_of_type_Bpje;
  private AEEditorMusicSwitchView jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicSwitchView;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.8F;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  private boolean d = true;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  
  public bpja(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755054);
    this.jdField_a_of_type_Int = paramInt;
    this.g = bpan.a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558546, null);
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicSwitchView = ((AEEditorMusicSwitchView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371512));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131371583));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369292));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369287));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376997));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366735));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicSwitchView.setSwitchClickListener(new bpjb(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bpjc(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    setOnShowListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_Bpir = new bpir(paramContext, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bpir);
    this.jdField_a_of_type_Bpir.a(bpis.a);
    setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private int a(int paramInt)
  {
    int n = this.jdField_a_of_type_Bpir.getItemCount();
    int m;
    if (paramInt < 0) {
      m = 0;
    }
    do
    {
      return m;
      m = paramInt;
    } while (paramInt <= n - 1);
    return n - 1;
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean)) {
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(this.jdField_a_of_type_Float * 100.0F));
      }
    }
    while ((paramInt != 2) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null)) {
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(this.jdField_b_of_type_Float * 100.0F));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setAlpha(0.4F);
    if (paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(this.jdField_b_of_type_Float * 100.0F));
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_Bpir == null)) {}
    while (this.jdField_a_of_type_Bpir.getItemCount() == 0) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837757);
    }
    if (this.jdField_a_of_type_Bpje != null) {
      this.jdField_a_of_type_Bpje.d(true);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837759);
    }
    if (this.jdField_a_of_type_Bpje != null) {
      this.jdField_a_of_type_Bpje.d(false);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837758);
    }
    if (this.jdField_a_of_type_Bpje != null) {
      this.jdField_a_of_type_Bpje.d(false);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new bpjd(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  @NonNull
  public List<bpis> a()
  {
    if (this.jdField_a_of_type_Bpir != null) {
      return this.jdField_a_of_type_Bpir.a();
    }
    return new LinkedList();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_b_of_type_Int = 1;
      d();
      bozv.a().a().f = 0;
    }
    for (;;)
    {
      bozr.a().o();
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_b_of_type_Int = 0;
        c();
        bozv.a().a().f = 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    paramInt = a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPosition(paramInt);
  }
  
  public void a(@NonNull bpis parambpis)
  {
    a(parambpis, 1, true, 2);
  }
  
  public void a(@Nullable bpis parambpis, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 1) {
      if (this.jdField_a_of_type_Bpje != null) {
        this.jdField_a_of_type_Bpje.x();
      }
    }
    do
    {
      return;
      if (!paramBoolean)
      {
        a(false);
        this.c = true;
        e();
        return;
      }
      this.i = true;
    } while (this.jdField_a_of_type_Bpje == null);
    this.jdField_a_of_type_Bpje.a(parambpis, paramInt1);
  }
  
  public void a(@Nullable bpje parambpje)
  {
    this.jdField_a_of_type_Bpje = parambpje;
  }
  
  public void a(@NonNull List<bpis> paramList)
  {
    if (this.jdField_a_of_type_Bpir != null) {
      this.jdField_a_of_type_Bpir.a(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.h))
    {
      this.h = true;
      if (isShowing()) {
        a(true);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.jdField_a_of_type_Bpje != null) {
      this.jdField_a_of_type_Bpje.b(this.i);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.j = paramBoolean1;
    this.l = paramBoolean2;
    if (paramBoolean1)
    {
      if (this.k)
      {
        this.k = false;
        this.jdField_a_of_type_Float = 0.2F;
        a(1, true, false);
        if (this.jdField_a_of_type_Bpje != null) {
          this.jdField_a_of_type_Bpje.a(this.jdField_a_of_type_Float);
        }
      }
      if ((this.jdField_b_of_type_Float > 0.0F) && (this.jdField_a_of_type_AndroidWidgetButton != null)) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.i = true;
      a(2, this.i, false);
      if (this.jdField_b_of_type_Int == 1) {
        d();
      }
      for (;;)
      {
        this.c = false;
        return;
        if (this.jdField_b_of_type_Int == 0)
        {
          d();
          c();
        }
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.i = false;
    if (paramBoolean2) {
      a(2, this.i, false);
    }
    for (;;)
    {
      this.c = true;
      e();
      return;
      a(2, this.i, true);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bpir != null) {
      this.jdField_a_of_type_Bpir.b();
    }
  }
  
  public void dismiss()
  {
    if (this.e) {
      return;
    }
    if (this.jdField_a_of_type_Bpje != null) {
      this.jdField_a_of_type_Bpje.y();
    }
    g();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131366735) {
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (m == 2131369292)
      {
        if (!this.c) {
          a();
        }
      }
      else if ((m == 2131369287) && (this.jdField_a_of_type_Bpje != null)) {
        this.jdField_a_of_type_Bpje.c(this.j);
      }
    }
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
    if (this.f)
    {
      this.f = false;
      if (this.h) {
        a(true);
      }
      if (!this.c) {
        if (this.jdField_b_of_type_Int == 1) {
          d();
        }
      }
    }
    while (this.jdField_a_of_type_Bpir == null)
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Int != 0);
      d();
      c();
      return;
      e();
      return;
    }
    this.jdField_a_of_type_Bpir.a();
  }
  
  public void show()
  {
    super.show();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpja
 * JD-Core Version:    0.7.0.1
 */