import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.view.AEEditorMusicWaveView;

public class bpij
  extends ReportDialog
  implements View.OnClickListener, bplc, bple
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bpin jdField_a_of_type_Bpin;
  private MoreLyricLayout jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout;
  private AEEditorMusicWaveView jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public bpij(@NonNull Context paramContext)
  {
    super(paramContext, 2131755054);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558545, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366769));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout = ((MoreLyricLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371325));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380097));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379812));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView = ((AEEditorMusicWaveView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362290));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379720));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379760));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380136));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setOnMoreLyricLayoutActionListener(new bpik(this));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setMoreBackground(paramContext.getResources().getDrawable(2131167247));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setLyricBackgroundEffect(new bpil(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setDragIndicatorListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView == null) {}
    while (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a() == this.jdField_a_of_type_Int) {
      return true;
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    int i = this.jdField_c_of_type_Int;
    b(paramInt);
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setLyricSeek(paramInt);
    }
    if (this.jdField_a_of_type_Bpin != null)
    {
      this.jdField_a_of_type_Bpin.a(paramInt, i + paramInt);
      this.jdField_a_of_type_Bpin.A();
    }
  }
  
  private void d()
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
  
  private void e()
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
    localAnimationSet.setAnimationListener(new bpim(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bpin != null) {
      this.jdField_a_of_type_Bpin.z();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bpin != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)) {
      this.jdField_a_of_type_Bpin.a(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(this.jdField_c_of_type_Int));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bpin != null) {
      this.jdField_a_of_type_Bpin.a(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable bpin parambpin)
  {
    this.jdField_a_of_type_Bpin = parambpin;
  }
  
  public void a(@NonNull bpis parambpis, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = parambpis.a();
    this.jdField_b_of_type_Int = parambpis.b();
    this.jdField_c_of_type_Int = paramInt2;
    bpio.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.jdField_b_of_type_Int));
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(parambpis.a(), AEEditorMusicHelper.a(parambpis), parambpis.b(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    c();
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setBackgroundResource(2131167247);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a(parambpis, paramInt1, true, false);
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bpin != null) {
      this.jdField_a_of_type_Bpin.A();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null) && (!this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.c()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setIndicatorIndexByVideo(paramInt1, paramInt2);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setCurrentPosition(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a((int)bpio.a().a(false));
    }
  }
  
  public void c()
  {
    if (this.e == null) {
      return;
    }
    if (a())
    {
      this.e.setText(2131689701);
      this.e.setBackgroundResource(0);
      return;
    }
    this.e.setText(2131689712);
    this.e.setBackgroundResource(2130837753);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bpkx.a(bpkx.a, paramInt1));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bpkx.a(bpkx.a, Math.min(paramInt2, this.jdField_b_of_type_Int)));
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    e();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131379720)
    {
      if (this.jdField_a_of_type_Bpin != null) {
        this.jdField_a_of_type_Bpin.B();
      }
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131379760)
      {
        if (this.jdField_a_of_type_Bpin != null) {
          this.jdField_a_of_type_Bpin.C();
        }
        dismiss();
      }
      else if ((i == 2131380136) && (!a()) && (this.jdField_a_of_type_Bpin != null))
      {
        this.jdField_a_of_type_Bpin.b(this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getWindow() != null) {}
    for (paramBundle = getWindow().getAttributes();; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle.gravity = 81;
        paramBundle.height = -1;
        paramBundle.width = -1;
        getWindow().setAttributes(paramBundle);
      }
      setCancelable(false);
      setCanceledOnTouchOutside(false);
      return;
    }
  }
  
  public void show()
  {
    super.show();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpij
 * JD-Core Version:    0.7.0.1
 */