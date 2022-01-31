import android.support.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

public class binp
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  private void a()
  {
    double d4 = this.f * 1.0D / this.e;
    double d5 = this.jdField_b_of_type_Int * 1.0D / this.jdField_a_of_type_Int;
    double d2 = this.e;
    double d3 = this.f;
    double d1;
    if (d4 > d5) {
      d1 = d5 * d2;
    }
    for (;;)
    {
      this.k = ((int)d2);
      this.l = ((int)d1);
      return;
      d1 = d3;
      if (d4 < d5)
      {
        d2 = 1.0D / d5 * d3;
        d1 = d3;
      }
    }
  }
  
  private String h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return i();
    }
    return e();
  }
  
  private String i()
  {
    if ((this.j != 0) && (this.i != 0)) {
      return this.j + "*" + this.i;
    }
    return "none";
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Int != 0)) {
      return this.jdField_b_of_type_Int + "*" + this.jdField_a_of_type_Int;
    }
    return "none";
  }
  
  public List<String> a()
  {
    a();
    return Arrays.asList(new String[] { "取景框大小: " + this.jdField_b_of_type_Int + "*" + this.jdField_a_of_type_Int, "设置的预览分辨率: " + this.d + "*" + this.c, "设置的照片分辨率: " + this.f + "*" + this.e, "普通渲染 & 截帧分辨率: " + this.h + "*" + this.g, "高清渲染 & 截帧分辨率: " + this.j + "*" + this.i, "大图拍照分辨率: " + this.l + "*" + this.k, "视频分辨率: " + this.n + "*" + this.m, "预览帧率: TODO" });
  }
  
  public String b()
  {
    if ((this.d != 0) && (this.c != 0)) {
      return this.d + "*" + this.c;
    }
    return "none";
  }
  
  public String c()
  {
    if ((this.f != 0) && (this.e != 0)) {
      return this.f + "*" + this.e;
    }
    return "none";
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return h();
    }
    return f();
  }
  
  public String e()
  {
    if ((this.h != 0) && (this.g != 0)) {
      return this.h + "*" + this.g;
    }
    return "none";
  }
  
  public String f()
  {
    a();
    if ((this.l != 0) && (this.k != 0)) {
      return this.l + "*" + this.k;
    }
    return "none";
  }
  
  public String g()
  {
    if ((this.n != 0) && (this.m != 0)) {
      return this.n + "*" + this.m;
    }
    return "none";
  }
  
  @NonNull
  public String toString()
  {
    List localList = a();
    int i2 = localList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append((String)localList.get(i1));
      if (i1 < i2 - 1) {
        localStringBuilder.append("\n");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binp
 * JD-Core Version:    0.7.0.1
 */