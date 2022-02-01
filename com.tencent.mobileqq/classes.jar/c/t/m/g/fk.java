package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

public final class fk
{
  private static double[][] a;
  private static double b;
  private static double c;
  private static double d;
  private static double e;
  private static List<fk.a> f;
  
  static
  {
    double[] arrayOfDouble1 = { 53.540306999999999D, 122.38082900000001D };
    double[] arrayOfDouble2 = { 53.399706999999999D, 120.821285D };
    double[] arrayOfDouble3 = { 52.749594000000002D, 119.91989100000001D };
    double[] arrayOfDouble4 = { 49.951219999999999D, 116.58004800000001D };
    double[] arrayOfDouble5 = { 47.901614000000002D, 115.43746899999999D };
    double[] arrayOfDouble6 = { 47.070121999999998D, 118.381805D };
    double[] arrayOfDouble7 = { 45.213003999999998D, 112.00973500000001D };
    double[] arrayOfDouble8 = { 42.714731999999998D, 107.83493D };
    double[] arrayOfDouble9 = { 42.779274999999998D, 100.100555D };
    double[] arrayOfDouble10 = { 42.908160000000002D, 96.497039999999998D };
    double[] arrayOfDouble11 = { 44.433779999999999D, 95.442352D };
    double[] arrayOfDouble12 = { 45.614037000000003D, 91.091766000000007D };
    double[] arrayOfDouble13 = { 47.606163000000002D, 91.003876000000005D };
    double[] arrayOfDouble14 = { 49.439557000000001D, 87.180633999999998D };
    double[] arrayOfDouble15 = { 47.398349000000003D, 82.961883999999998D };
    double[] arrayOfDouble16 = { 44.964798000000002D, 79.753876000000005D };
    double[] arrayOfDouble17 = { 42.358544000000002D, 79.885711999999998D };
    double[] arrayOfDouble18 = { 40.513798999999999D, 73.689423000000005D };
    double[] arrayOfDouble19 = { 36.562600000000003D, 73.758774000000003D };
    double[] arrayOfDouble20 = { 33.760882000000002D, 76.457977D };
    double[] arrayOfDouble21 = { 28.497661000000001D, 84.280242999999999D };
    double[] arrayOfDouble22 = { 27.166695000000001D, 88.394278999999997D };
    double[] arrayOfDouble23 = { 26.755420999999998D, 92.118645000000001D };
    double[] arrayOfDouble24 = { 27.936181000000001D, 97.379379D };
    double[] arrayOfDouble25 = { 24.166802000000001D, 97.115707D };
    double[] arrayOfDouble26 = { 21.350781000000001D, 99.972153000000006D };
    double[] arrayOfDouble27 = { 23.120153999999999D, 105.355453D };
    double[] arrayOfDouble28 = { 21.915019000000001D, 106.64660499999999D };
    double[] arrayOfDouble29 = { 21.350781000000001D, 107.684555D };
    double[] arrayOfDouble30 = { 16.762467999999998D, 109.002914D };
    double[] arrayOfDouble31 = { 18.729502D, 111.174774D };
    double[] arrayOfDouble32 = { 21.268899999999999D, 112.782211D };
    double[] arrayOfDouble33 = { 22.998851999999999D, 117.176743D };
    double[] arrayOfDouble34 = { 25.019304000000002D, 119.97339100000001D };
    double[] arrayOfDouble35 = { 27.117813000000002D, 120.89012099999999D };
    double[] arrayOfDouble36 = { 27.761330000000001D, 121.82104099999999D };
    double[] arrayOfDouble37 = { 30.097612999999999D, 123.45165299999999D };
    double[] arrayOfDouble38 = { 33.155948000000002D, 120.999985D };
    double[] arrayOfDouble39 = { 35.209721999999999D, 120.143051D };
    double[] arrayOfDouble40 = { 36.914763999999998D, 122.91332199999999D };
    double[] arrayOfDouble41 = { 39.842286000000001D, 124.273911D };
    double[] arrayOfDouble42 = { 41.294316999999999D, 128.27293399999999D };
    double[] arrayOfDouble43 = { 42.815550999999999D, 131.19787199999999D };
    double[] arrayOfDouble44 = { 48.04871D, 135.04051200000001D };
    double[] arrayOfDouble45 = { 48.618385000000004D, 134.33738700000001D };
    double[] arrayOfDouble46 = { 49.196064D, 130.53611799999999D };
    double[] arrayOfDouble47 = { 50.708634000000004D, 127.613754D };
    double[] arrayOfDouble48 = { 53.133589999999998D, 125.833969D };
    a = new double[][] { arrayOfDouble1, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4, arrayOfDouble5, arrayOfDouble6, arrayOfDouble7, arrayOfDouble8, arrayOfDouble9, arrayOfDouble10, arrayOfDouble11, arrayOfDouble12, arrayOfDouble13, arrayOfDouble14, arrayOfDouble15, arrayOfDouble16, arrayOfDouble17, arrayOfDouble18, arrayOfDouble19, arrayOfDouble20, { 31.989442D, 77.688445999999999D }, arrayOfDouble21, arrayOfDouble22, arrayOfDouble23, arrayOfDouble24, arrayOfDouble25, arrayOfDouble26, { 21.105D, 101.707993D }, arrayOfDouble27, arrayOfDouble28, arrayOfDouble29, arrayOfDouble30, arrayOfDouble31, arrayOfDouble32, arrayOfDouble33, arrayOfDouble34, arrayOfDouble35, arrayOfDouble36, arrayOfDouble37, arrayOfDouble38, arrayOfDouble39, arrayOfDouble40, arrayOfDouble41, arrayOfDouble42, arrayOfDouble43, { 45.026949999999999D, 133.17283599999999D }, arrayOfDouble44, arrayOfDouble45, { 47.886881000000002D, 131.70066800000001D }, arrayOfDouble46, arrayOfDouble47, arrayOfDouble48, { 53.657660999999997D, 123.329086D } };
    b = 360.0D;
    c = 360.0D;
    d = -360.0D;
    e = -360.0D;
    f = new ArrayList();
    a();
  }
  
  private static void a()
  {
    int i = 0;
    while (i < a.length)
    {
      double d1 = a[i][0];
      double d2 = a[i][1];
      if (d1 < c) {
        c = d1;
      }
      if (d1 > e) {
        e = d1;
      }
      if (d2 < b) {
        b = d2;
      }
      if (d2 > d) {
        d = d2;
      }
      f.add(new fk.a(d1, d2));
      i += 1;
    }
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < c) || (paramDouble2 < b) || (paramDouble1 > e) || (paramDouble2 > d)) {
      return false;
    }
    Object localObject = (fk.a)f.get(0);
    int m = f.size();
    int j = 0;
    int i = 1;
    while (i <= m)
    {
      fk.a locala = (fk.a)f.get(i % m);
      int k = j;
      if (paramDouble1 > Math.min(((fk.a)localObject).a, locala.a))
      {
        k = j;
        if (paramDouble1 <= Math.max(((fk.a)localObject).a, locala.a))
        {
          k = j;
          if (paramDouble2 <= Math.max(((fk.a)localObject).b, locala.b))
          {
            k = j;
            if (((fk.a)localObject).a != locala.a)
            {
              double d1 = (paramDouble1 - ((fk.a)localObject).a) * (locala.b - ((fk.a)localObject).b) / (locala.a - ((fk.a)localObject).a);
              double d2 = ((fk.a)localObject).b;
              if (((fk.a)localObject).b != locala.b)
              {
                k = j;
                if (paramDouble2 > d1 + d2) {}
              }
              else
              {
                k = j + 1;
              }
            }
          }
        }
      }
      i += 1;
      localObject = locala;
      j = k;
    }
    if (j % 2 == 0) {}
    for (i = 0; i != 0; i = 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.fk
 * JD-Core Version:    0.7.0.1
 */