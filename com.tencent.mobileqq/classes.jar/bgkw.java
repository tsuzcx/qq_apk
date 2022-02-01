import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class bgkw
{
  private agwg jdField_a_of_type_Agwg;
  private bgkx jdField_a_of_type_Bgkx;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashMap<Long, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private HashMap<Long, Long> c = new HashMap();
  private HashMap<Long, Long> d = new HashMap();
  
  public bgkw(bgkv parambgkv, BaseChatPie paramBaseChatPie, agvc paramagvc)
  {
    this.jdField_a_of_type_Bgkx = ((bgkx)parambgkv);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agwg = ((agwg)paramagvc);
  }
  
  private int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {
      return;
    }
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), "0X800B19D", "0X800B19D", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {
      return;
    }
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), "0X800B19E", "0X800B19E", 0, 0, "", "", String.valueOf(paramInt), "");
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {}
    String str;
    do
    {
      return;
      str = "0X800B19A";
      if (paramInt == 1) {
        str = "0X800B19F";
      }
    } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof bgkm)));
    paramView = (bgkm)paramView.getTag();
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), str, str, 0, 0, String.valueOf(paramView.c()), "", String.valueOf(this.jdField_a_of_type_Bgkx.a()), "");
    this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramView.c()));
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramLong1, paramLong2);
    this.d.put(paramLong1, paramLong2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (!this.jdField_b_of_type_JavaUtilHashSet.contains(localLong)))
      {
        this.jdField_b_of_type_JavaUtilHashSet.add(localLong);
        bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), "0X800B199", "0X800B199", 0, 0, String.valueOf(localLong), "", "", "");
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void b(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {}
    String str;
    do
    {
      return;
      str = "0X800B1A0";
      if (paramInt == 0) {
        str = "0X800B19C";
      }
    } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof bgkm)));
    paramView = (bgkm)paramView.getTag();
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), str, str, 0, 0, String.valueOf(paramView.c()), String.valueOf(this.jdField_a_of_type_Bgkx.a()), String.valueOf(a(paramView.a())), "");
    this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramView.a()));
  }
  
  public void b(Long paramLong1, Long paramLong2)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(paramLong1, paramLong2);
    this.d.put(paramLong1, paramLong2);
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_Bgkx == null)) {
      return;
    }
    String str = "";
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (localLong != null) {
        str = str + ";" + String.valueOf(localLong);
      }
    }
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Agwg.a(), "0X800B198", "0X800B198", 0, 0, String.valueOf(this.c.size()), String.valueOf(this.jdField_a_of_type_Bgkx.a()), str, String.valueOf(this.d.size()));
    this.c.clear();
    this.d.clear();
  }
  
  public void c(Long paramLong1, Long paramLong2)
  {
    this.c.put(paramLong1, paramLong2);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Agwg = null;
    this.jdField_a_of_type_Bgkx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkw
 * JD-Core Version:    0.7.0.1
 */