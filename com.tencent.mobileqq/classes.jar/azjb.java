import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azjb
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
  public static SparseArray<azku> a;
  public static List<Integer> a;
  public static boolean a;
  public static int b;
  public static List<azjp> b;
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
  
  static azku a(int paramInt)
  {
    return (azku)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
  
  static void a(List<azku> paramList)
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azku localazku = (azku)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status : " + localazku);
      }
      jdField_a_of_type_AndroidUtilSparseArray.put((int)localazku.jdField_a_of_type_Long, localazku);
      Object localObject;
      if (("category".equalsIgnoreCase(localazku.d)) && (localazku.jdField_a_of_type_Azkv != null))
      {
        localObject = new azjp((int)localazku.jdField_a_of_type_Long, localazku.jdField_a_of_type_JavaLangString, localazku.jdField_a_of_type_Azkv.jdField_a_of_type_JavaLangString, localazku.jdField_a_of_type_Azkv.jdField_a_of_type_Int);
        d = localazku.jdField_a_of_type_Azkv.jdField_b_of_type_Int;
        g = localazku.jdField_a_of_type_Azkv.c;
        f = localazku.jdField_a_of_type_Azkv.d;
        e = localazku.jdField_a_of_type_Azkv.e;
        jdField_a_of_type_Double = localazku.jdField_a_of_type_Azkv.jdField_a_of_type_Double;
        h = a(localazku.jdField_a_of_type_Azkv.f);
        j = localazku.jdField_a_of_type_Azkv.g;
        l = localazku.jdField_a_of_type_Azkv.h;
        if (QLog.isColorLevel()) {
          QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazku.jdField_a_of_type_Long + " category : " + localObject);
        }
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        localObject = localazku.jdField_a_of_type_Azkw;
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazku.jdField_a_of_type_Long + " sensor null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazku.jdField_a_of_type_Long + " sensor: " + localObject);
          }
          switch ((int)localazku.jdField_a_of_type_Long)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. dropped status: " + localazku.jdField_a_of_type_Long + " sensor: " + localObject);
            }
            break;
          case 41012: 
            x = ((azkw)localObject).jdField_b_of_type_Int;
            y = ((azkw)localObject).c;
            B = ((azkw)localObject).d;
            jdField_a_of_type_Int = ((azkw)localObject).e;
            jdField_b_of_type_Int = ((azkw)localObject).f;
            break;
          case 41013: 
            z = ((azkw)localObject).jdField_b_of_type_Int;
            A = ((azkw)localObject).c;
            break;
          case 41031: 
            t = ((azkw)localObject).jdField_b_of_type_Int;
            u = ((azkw)localObject).c;
            break;
          case 41014: 
            v = ((azkw)localObject).jdField_b_of_type_Int;
            w = ((azkw)localObject).c;
            c = a(((azkw)localObject).g);
            o = ((azkw)localObject).h;
            p = ((azkw)localObject).i;
            m = a(((azkw)localObject).j);
            n = a(((azkw)localObject).k);
            r = a(((azkw)localObject).m);
            q = a(((azkw)localObject).l);
            s = ((azkw)localObject).n;
            C = ((azkw)localObject).d;
            N = m * 2;
            break;
          case 41032: 
            if ((((azkw)localObject).jdField_b_of_type_Int >= 0) && (((azkw)localObject).jdField_b_of_type_Int < 23) && (((azkw)localObject).c >= 0) && (((azkw)localObject).c < 23))
            {
              D = ((azkw)localObject).jdField_b_of_type_Int;
              E = ((azkw)localObject).c;
            }
            break;
          case 41042: 
            F = ((azkw)localObject).o;
            G = ((azkw)localObject).p;
            M = ((azkw)localObject).q;
            if (((azkw)localObject).t == 1)
            {
              bool = true;
              label743:
              jdField_a_of_type_Boolean = bool;
              if (((azkw)localObject).r != 1) {
                break label804;
              }
            }
            label804:
            for (boolean bool = true;; bool = false)
            {
              jdField_b_of_type_Boolean = bool;
              H = ((azkw)localObject).s;
              J = ((azkw)localObject).u;
              I = ((azkw)localObject).v;
              K = ((azkw)localObject).w;
              L = ((azkw)localObject).x;
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
      if (((azjp)localIterator.next()).a() == paramLong) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjb
 * JD-Core Version:    0.7.0.1
 */