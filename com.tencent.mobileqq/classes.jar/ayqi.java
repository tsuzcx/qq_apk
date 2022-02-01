import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayqi
{
  public static int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static double a;
  public static int a;
  public static SparseArray<aysb> a;
  public static List<Integer> a;
  public static boolean a;
  public static int b;
  public static List<ayqw> b;
  public static boolean b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 3;
    c = 300000;
    d = 2;
    e = 50;
    f = 50;
    g = 50;
    jdField_a_of_type_Double = 1.0D;
    h = 120000;
    i = 10000;
    j = 10;
    k = 20;
    l = 100;
    m = 60000;
    n = 30000;
    o = 3;
    p = 5;
    q = 30000;
    r = 600000;
    s = 50;
    t = 10;
    u = 20;
    v = 30;
    w = 120;
    x = 500;
    y = 1500;
    z = 100;
    A = 400;
    B = 20;
    C = 3;
    E = 5;
    F = 40;
    G = 200;
    H = 120000;
    I = 60000;
    J = 100;
    K = 120000;
    L = 120000;
    M = 50;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    N = 300000;
    O = 600000;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  static int a(int paramInt)
  {
    return paramInt * 1000;
  }
  
  static aysb a(int paramInt)
  {
    return (aysb)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 40001: 
      return "在地球";
    case 41012: 
      return "行走中";
    case 41013: 
      return "跑步中";
    case 41031: 
      return "骑行中";
    case 41014: 
      return "开车中";
    case 41032: 
      return "熬夜中";
    case 41042: 
      return "移动中";
    case 41033: 
      return "在小区";
    case 41034: 
      return "在学校";
    case 41035: 
      return "在公园";
    case 41036: 
      return "在海边";
    case 41037: 
      return "在机场";
    case 41038: 
      return "在商场";
    case 41039: 
      return "在咖啡厅";
    }
    return "在餐厅";
  }
  
  static void a(List<aysb> paramList)
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aysb localaysb = (aysb)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status : " + localaysb);
      }
      jdField_a_of_type_AndroidUtilSparseArray.put((int)localaysb.jdField_a_of_type_Long, localaysb);
      Object localObject;
      if (("category".equalsIgnoreCase(localaysb.d)) && (localaysb.jdField_a_of_type_Aysc != null))
      {
        localObject = new ayqw((int)localaysb.jdField_a_of_type_Long, localaysb.jdField_a_of_type_JavaLangString, localaysb.jdField_a_of_type_Aysc.jdField_a_of_type_JavaLangString, localaysb.jdField_a_of_type_Aysc.jdField_a_of_type_Int);
        d = localaysb.jdField_a_of_type_Aysc.jdField_b_of_type_Int;
        g = localaysb.jdField_a_of_type_Aysc.c;
        f = localaysb.jdField_a_of_type_Aysc.d;
        e = localaysb.jdField_a_of_type_Aysc.e;
        jdField_a_of_type_Double = localaysb.jdField_a_of_type_Aysc.jdField_a_of_type_Double;
        h = a(localaysb.jdField_a_of_type_Aysc.f);
        j = localaysb.jdField_a_of_type_Aysc.g;
        l = localaysb.jdField_a_of_type_Aysc.h;
        if (QLog.isColorLevel()) {
          QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localaysb.jdField_a_of_type_Long + " category : " + localObject);
        }
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        localObject = localaysb.jdField_a_of_type_Aysd;
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localaysb.jdField_a_of_type_Long + " sensor null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localaysb.jdField_a_of_type_Long + " sensor: " + localObject);
          }
          switch ((int)localaysb.jdField_a_of_type_Long)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. dropped status: " + localaysb.jdField_a_of_type_Long + " sensor: " + localObject);
            }
            break;
          case 41012: 
            x = ((aysd)localObject).jdField_b_of_type_Int;
            y = ((aysd)localObject).c;
            B = ((aysd)localObject).d;
            jdField_a_of_type_Int = ((aysd)localObject).e;
            jdField_b_of_type_Int = ((aysd)localObject).f;
            break;
          case 41013: 
            z = ((aysd)localObject).jdField_b_of_type_Int;
            A = ((aysd)localObject).c;
            break;
          case 41031: 
            t = ((aysd)localObject).jdField_b_of_type_Int;
            u = ((aysd)localObject).c;
            break;
          case 41014: 
            v = ((aysd)localObject).jdField_b_of_type_Int;
            w = ((aysd)localObject).c;
            c = a(((aysd)localObject).g);
            o = ((aysd)localObject).h;
            p = ((aysd)localObject).i;
            m = a(((aysd)localObject).j);
            n = a(((aysd)localObject).k);
            r = a(((aysd)localObject).m);
            q = a(((aysd)localObject).l);
            s = ((aysd)localObject).n;
            C = ((aysd)localObject).d;
            N = m * 2;
            break;
          case 41032: 
            if ((((aysd)localObject).jdField_b_of_type_Int >= 0) && (((aysd)localObject).jdField_b_of_type_Int < 23) && (((aysd)localObject).c >= 0) && (((aysd)localObject).c < 23))
            {
              D = ((aysd)localObject).jdField_b_of_type_Int;
              E = ((aysd)localObject).c;
            }
            break;
          case 41042: 
            F = ((aysd)localObject).o;
            G = ((aysd)localObject).p;
            M = ((aysd)localObject).q;
            if (((aysd)localObject).t == 1)
            {
              bool = true;
              label743:
              jdField_a_of_type_Boolean = bool;
              if (((aysd)localObject).r != 1) {
                break label804;
              }
            }
            label804:
            for (boolean bool = true;; bool = false)
            {
              jdField_b_of_type_Boolean = bool;
              H = ((aysd)localObject).s;
              J = ((aysd)localObject).u;
              I = ((aysd)localObject).v;
              K = ((aysd)localObject).w;
              L = ((aysd)localObject).x;
              break;
              bool = false;
              break label743;
            }
          }
        }
      }
    }
  }
  
  static boolean a(long paramLong)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ayqw)localIterator.next()).a() == paramLong) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqi
 * JD-Core Version:    0.7.0.1
 */