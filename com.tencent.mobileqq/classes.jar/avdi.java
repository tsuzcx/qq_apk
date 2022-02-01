import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avdi
  extends avdh
{
  private List<avdg> a = new ArrayList();
  
  public avdi(DanmakuLayout paramDanmakuLayout)
  {
    super(paramDanmakuLayout);
  }
  
  public void a(long paramLong)
  {
    if (this.a.size() > 0)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        avdg localavdg = (avdg)localIterator.next();
        if (!localavdg.a(paramLong, this.jdField_b_of_type_Int))
        {
          localavdg.a();
          localIterator.remove();
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.a.size() > 0;
  }
  
  public boolean a(avdg paramavdg)
  {
    boolean bool;
    if (!a()) {
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.a.add(paramavdg);
        if (paramavdg.jdField_a_of_type_AndroidWidgetTextView.getParent() == null) {
          this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout.addView(paramavdg.jdField_a_of_type_AndroidWidgetTextView);
        }
      }
      return bool;
      avdg localavdg = (avdg)this.a.get(this.a.size() - 1);
      if (localavdg.jdField_a_of_type_Float > localavdg.jdField_b_of_type_Int + 40 + Math.random() * 40.0D)
      {
        avdg.a(paramavdg);
        if ((paramavdg.jdField_b_of_type_Float < localavdg.jdField_b_of_type_Float) || ((localavdg.jdField_a_of_type_Float - localavdg.jdField_b_of_type_Int) / (paramavdg.jdField_b_of_type_Float - localavdg.jdField_b_of_type_Float) > (DanmakuLayout.a(this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout) + localavdg.jdField_b_of_type_Int - localavdg.jdField_a_of_type_Float) / localavdg.jdField_b_of_type_Float))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public boolean b()
  {
    if (this.a.size() > 0) {}
    for (boolean bool = true; bool; bool = false)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ((avdg)localIterator.next()).a();
        localIterator.remove();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdi
 * JD-Core Version:    0.7.0.1
 */