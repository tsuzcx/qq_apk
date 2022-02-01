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

public class bogo
  extends ReportDialog
  implements View.OnClickListener, bojh, bojj
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bogs jdField_a_of_type_Bogs;
  private MoreLyricLayout jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout;
  private AEEditorMusicWaveView jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public bogo(@NonNull Context paramContext)
  {
    super(paramContext, 2131755054);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558543, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366718));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout = ((MoreLyricLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371218));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379914));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379637));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView = ((AEEditorMusicWaveView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379548));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379587));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379952));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setOnMoreLyricLayoutActionListener(new bogp(this));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setMoreBackground(paramContext.getResources().getDrawable(2131167224));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setLyricBackgroundEffect(new bogq(this));
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
    if (this.jdField_a_of_type_Bogs != null)
    {
      this.jdField_a_of_type_Bogs.a(paramInt, i + paramInt);
      this.jdField_a_of_type_Bogs.A();
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
    localAnimationSet.setAnimationListener(new bogr(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bogs != null) {
      this.jdField_a_of_type_Bogs.z();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bogs != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)) {
      this.jdField_a_of_type_Bogs.a(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(this.jdField_c_of_type_Int));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bogs != null) {
      this.jdField_a_of_type_Bogs.a(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable bogs parambogs)
  {
    this.jdField_a_of_type_Bogs = parambogs;
  }
  
  public void a(@NonNull bogx parambogx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = parambogx.a();
    this.jdField_b_of_type_Int = parambogx.b();
    this.jdField_c_of_type_Int = paramInt2;
    bogt.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.jdField_b_of_type_Int));
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.a(parambogx.a(), AEEditorMusicHelper.a(parambogx), parambogx.b(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    c();
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.setBackgroundResource(2131167224);
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a(parambogx, paramInt1, true, false);
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bogs != null) {
      this.jdField_a_of_type_Bogs.A();
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
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout.a((int)bogt.a().a(false));
    }
  }
  
  public void c()
  {
    if (this.e == null) {
      return;
    }
    if (a())
    {
      this.e.setText(2131689696);
      this.e.setBackgroundResource(0);
      return;
    }
    this.e.setText(2131689707);
    this.e.setBackgroundResource(2130837746);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bojc.a(bojc.a, paramInt1));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bojc.a(bojc.a, Math.min(paramInt2, this.jdField_b_of_type_Int)));
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
    if (i == 2131379548)
    {
      if (this.jdField_a_of_type_Bogs != null) {
        this.jdField_a_of_type_Bogs.B();
      }
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131379587)
      {
        if (this.jdField_a_of_type_Bogs != null) {
          this.jdField_a_of_type_Bogs.C();
        }
        dismiss();
      }
      else if ((i == 2131379952) && (!a()) && (this.jdField_a_of_type_Bogs != null))
      {
        this.jdField_a_of_type_Bogs.b(this.jdField_a_of_type_Int);
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
 * Qualified Name:     bogo
 * JD-Core Version:    0.7.0.1
 */