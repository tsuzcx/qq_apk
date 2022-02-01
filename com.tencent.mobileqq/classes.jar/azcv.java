import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azcv
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
  public static SparseArray<azeo> a;
  public static List<Integer> a;
  public static boolean a;
  public static int b;
  public static List<azdj> b;
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
  
  static azeo a(int paramInt)
  {
    return (azeo)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
  
  static void a(List<azeo> paramList)
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azeo localazeo = (azeo)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status : " + localazeo);
      }
      jdField_a_of_type_AndroidUtilSparseArray.put((int)localazeo.jdField_a_of_type_Long, localazeo);
      Object localObject;
      if (("category".equalsIgnoreCase(localazeo.e)) && (localazeo.jdField_a_of_type_Azep != null))
      {
        localObject = new azdj((int)localazeo.jdField_a_of_type_Long, localazeo.b, localazeo.jdField_a_of_type_Azep.jdField_a_of_type_JavaLangString, localazeo.jdField_a_of_type_Azep.jdField_a_of_type_Int);
        d = localazeo.jdField_a_of_type_Azep.jdField_b_of_type_Int;
        g = localazeo.jdField_a_of_type_Azep.c;
        f = localazeo.jdField_a_of_type_Azep.d;
        e = localazeo.jdField_a_of_type_Azep.e;
        jdField_a_of_type_Double = localazeo.jdField_a_of_type_Azep.jdField_a_of_type_Double;
        h = a(localazeo.jdField_a_of_type_Azep.f);
        j = localazeo.jdField_a_of_type_Azep.g;
        l = localazeo.jdField_a_of_type_Azep.h;
        if (QLog.isColorLevel()) {
          QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazeo.jdField_a_of_type_Long + " category : " + localObject);
        }
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        localObject = localazeo.jdField_a_of_type_Azeq;
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazeo.jdField_a_of_type_Long + " sensor null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localazeo.jdField_a_of_type_Long + " sensor: " + localObject);
          }
          switch ((int)localazeo.jdField_a_of_type_Long)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. dropped status: " + localazeo.jdField_a_of_type_Long + " sensor: " + localObject);
            }
            break;
          case 41012: 
            x = ((azeq)localObject).jdField_b_of_type_Int;
            y = ((azeq)localObject).c;
            B = ((azeq)localObject).d;
            jdField_a_of_type_Int = ((azeq)localObject).e;
            jdField_b_of_type_Int = ((azeq)localObject).f;
            break;
          case 41013: 
            z = ((azeq)localObject).jdField_b_of_type_Int;
            A = ((azeq)localObject).c;
            break;
          case 41031: 
            t = ((azeq)localObject).jdField_b_of_type_Int;
            u = ((azeq)localObject).c;
            break;
          case 41014: 
            v = ((azeq)localObject).jdField_b_of_type_Int;
            w = ((azeq)localObject).c;
            c = a(((azeq)localObject).g);
            o = ((azeq)localObject).h;
            p = ((azeq)localObject).i;
            m = a(((azeq)localObject).j);
            n = a(((azeq)localObject).k);
            r = a(((azeq)localObject).m);
            q = a(((azeq)localObject).l);
            s = ((azeq)localObject).n;
            C = ((azeq)localObject).d;
            N = m * 2;
            break;
          case 41032: 
            if ((((azeq)localObject).jdField_b_of_type_Int >= 0) && (((azeq)localObject).jdField_b_of_type_Int < 23) && (((azeq)localObject).c >= 0) && (((azeq)localObject).c < 23))
            {
              D = ((azeq)localObject).jdField_b_of_type_Int;
              E = ((azeq)localObject).c;
            }
            break;
          case 41042: 
            F = ((azeq)localObject).o;
            G = ((azeq)localObject).p;
            M = ((azeq)localObject).q;
            if (((azeq)localObject).t == 1)
            {
              bool = true;
              label743:
              jdField_a_of_type_Boolean = bool;
              if (((azeq)localObject).r != 1) {
                break label804;
              }
            }
            label804:
            for (boolean bool = true;; bool = false)
            {
              jdField_b_of_type_Boolean = bool;
              H = ((azeq)localObject).s;
              J = ((azeq)localObject).u;
              I = ((azeq)localObject).v;
              K = ((azeq)localObject).w;
              L = ((azeq)localObject).x;
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
      if (((azdj)localIterator.next()).a() == paramLong) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcv
 * JD-Core Version:    0.7.0.1
 */