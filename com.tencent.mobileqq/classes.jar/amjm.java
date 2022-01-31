import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amjm
  extends RecyclerView.Adapter<amjo>
  implements Animator.AnimatorListener
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  ViewPropertyAnimator jdField_a_of_type_AndroidViewViewPropertyAnimator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = -1;
  
  public amjm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public amjo a(ViewGroup paramViewGroup, int paramInt)
  {
    return new amjo(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558814, paramViewGroup, false));
  }
  
  public void a(amjo paramamjo, int paramInt)
  {
    label179:
    View localView;
    switch (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue() & 0xFFFF0000)
    {
    default: 
      if ((paramInt != this.jdField_a_of_type_Int) || (Build.VERSION.SDK_INT <= 19)) {
        break label463;
      }
      if ((this.jdField_a_of_type_AndroidViewViewPropertyAnimator == null) || (this.b == -1) || (this.b == this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_AndroidViewViewPropertyAnimator = paramamjo.jdField_a_of_type_AndroidViewView.animate();
      }
      if (paramamjo.jdField_a_of_type_AndroidViewView.getMeasuredWidth() == 0) {
        break label454;
      }
      if ((this.b == -1) || (this.b == this.jdField_a_of_type_Int))
      {
        f = this.jdField_a_of_type_Float;
        this.jdField_a_of_type_Float = f;
        localView = paramamjo.jdField_a_of_type_AndroidViewView;
        if (this.jdField_a_of_type_Float != 0.0F) {
          break label446;
        }
      }
      break;
    }
    label446:
    for (float f = -paramamjo.jdField_a_of_type_AndroidViewView.getMeasuredWidth();; f = this.jdField_a_of_type_Float)
    {
      localView.setTranslationX(f);
      this.jdField_a_of_type_AndroidViewViewPropertyAnimator.setDuration((int)((paramamjo.jdField_a_of_type_AndroidViewView.getMeasuredWidth() - Math.abs(this.jdField_a_of_type_Float)) / paramamjo.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) * 200).translationX(0.0F).setListener(this).setUpdateListener(new amjn(this)).start();
      return;
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramamjo.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable);
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramamjo.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(300);
      paramamjo.b.setBackgroundResource(0);
      paramamjo.b.setVisibility(8);
      break;
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramamjo.b.setBackgroundResource(2130838970);
      paramamjo.b.setVisibility(0);
      break;
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramamjo.b.setBackgroundResource(2130838973);
      paramamjo.b.setVisibility(0);
      break;
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramamjo.b.setBackgroundResource(2130838979);
      paramamjo.b.setVisibility(0);
      break;
      paramamjo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramamjo.b.setBackgroundResource(2130838982);
      paramamjo.b.setVisibility(0);
      break;
      f = 0.0F;
      break label179;
    }
    label454:
    paramamjo.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
    return;
    label463:
    paramamjo.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
  }
  
  public void a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = -1;
    int i = 0;
    if (i < paramList.size())
    {
      ColorNote localColorNote = (ColorNote)paramList.get(i);
      if (localColorNote.isOpen()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localColorNote.animate) && (this.jdField_a_of_type_Int == -1)) {
          this.jdField_a_of_type_Int = i;
        }
        int j = localColorNote.getServiceType();
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j & 0xFFFF0000));
      }
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a().iterator();
    while (paramAnimator.hasNext()) {
      ((ColorNote)paramAnimator.next()).animate = false;
    }
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */