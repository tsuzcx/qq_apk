package androidx.constraintlayout.motion.utils;

public class LinearCurveFit
  extends CurveFit
{
  private static final String TAG = "LinearCurveFit";
  private double[] mT;
  private double mTotalLength = (0.0D / 0.0D);
  private double[][] mY;
  
  public LinearCurveFit(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    int i = paramArrayOfDouble.length;
    i = paramArrayOfDouble1[0].length;
    this.mT = paramArrayOfDouble;
    this.mY = paramArrayOfDouble1;
    if (i > 2)
    {
      double d1 = 0.0D;
      double d2 = d1;
      i = 0;
      while (i < paramArrayOfDouble.length)
      {
        double d4 = paramArrayOfDouble1[i][0];
        double d3 = paramArrayOfDouble1[i][0];
        if (i > 0) {
          Math.hypot(d4 - d1, d3 - d2);
        }
        i += 1;
        d1 = d4;
        d2 = d3;
      }
      this.mTotalLength = 0.0D;
    }
  }
  
  private double getLength2D(double paramDouble)
  {
    if (Double.isNaN(this.mTotalLength)) {
      return 0.0D;
    }
    Object localObject = this.mT;
    int i = localObject.length;
    if (paramDouble <= localObject[0]) {
      return 0.0D;
    }
    int k = i - 1;
    if (paramDouble >= localObject[k]) {
      return this.mTotalLength;
    }
    double d2 = 0.0D;
    double d1 = d2;
    double d4 = d1;
    i = 0;
    double d3 = d1;
    while (i < k)
    {
      localObject = this.mY;
      double d6 = localObject[i][0];
      double d5 = localObject[i][1];
      d1 = d2;
      if (i > 0) {
        d1 = d2 + Math.hypot(d6 - d3, d5 - d4);
      }
      localObject = this.mT;
      if (paramDouble == localObject[i]) {
        return d1;
      }
      int j = i + 1;
      if (paramDouble < localObject[j])
      {
        d2 = localObject[j];
        d3 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d2 - d3);
        localObject = this.mY;
        d2 = localObject[i][0];
        d3 = localObject[j][0];
        d4 = localObject[i][1];
        double d7 = localObject[j][1];
        double d8 = 1.0D - paramDouble;
        return d1 + Math.hypot(d5 - (d4 * d8 + d7 * paramDouble), d6 - (d2 * d8 + d3 * paramDouble));
      }
      i = j;
      d3 = d6;
      d4 = d5;
      d2 = d1;
    }
    return 0.0D;
  }
  
  public double getPos(double paramDouble, int paramInt)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    int i = 0;
    if (paramDouble <= localObject[0]) {
      return this.mY[0][paramInt];
    }
    int k = j - 1;
    if (paramDouble >= localObject[k]) {
      return this.mY[k][paramInt];
    }
    while (i < k)
    {
      localObject = this.mT;
      if (paramDouble == localObject[i]) {
        return this.mY[i][paramInt];
      }
      j = i + 1;
      if (paramDouble < localObject[j])
      {
        double d1 = localObject[j];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        localObject = this.mY;
        return localObject[i][paramInt] * (1.0D - paramDouble) + localObject[j][paramInt] * paramDouble;
      }
      i = j;
    }
    return 0.0D;
  }
  
  public void getPos(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      i = 0;
      while (i < n)
      {
        paramArrayOfDouble[i] = this.mY[0][i];
        i += 1;
      }
      return;
    }
    int i1 = j - 1;
    if (paramDouble >= localObject[i1])
    {
      while (i < n)
      {
        paramArrayOfDouble[i] = this.mY[i1][i];
        i += 1;
      }
      return;
    }
    int m;
    for (i = 0; i < i1; i = m)
    {
      if (paramDouble == this.mT[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfDouble[j] = this.mY[i][j];
          j += 1;
        }
      }
      localObject = this.mT;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        j = k;
        while (j < n)
        {
          localObject = this.mY;
          paramArrayOfDouble[j] = (localObject[i][j] * (1.0D - paramDouble) + localObject[m][j] * paramDouble);
          j += 1;
        }
        return;
      }
    }
  }
  
  public void getPos(double paramDouble, float[] paramArrayOfFloat)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      i = 0;
      while (i < n)
      {
        paramArrayOfFloat[i] = ((float)this.mY[0][i]);
        i += 1;
      }
      return;
    }
    int i1 = j - 1;
    if (paramDouble >= localObject[i1])
    {
      while (i < n)
      {
        paramArrayOfFloat[i] = ((float)this.mY[i1][i]);
        i += 1;
      }
      return;
    }
    int m;
    for (i = 0; i < i1; i = m)
    {
      if (paramDouble == this.mT[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfFloat[j] = ((float)this.mY[i][j]);
          j += 1;
        }
      }
      localObject = this.mT;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m];
        double d2 = localObject[i];
        paramDouble = (paramDouble - localObject[i]) / (d1 - d2);
        j = k;
        while (j < n)
        {
          localObject = this.mY;
          paramArrayOfFloat[j] = ((float)(localObject[i][j] * (1.0D - paramDouble) + localObject[m][j] * paramDouble));
          j += 1;
        }
        return;
      }
    }
  }
  
  public double getSlope(double paramDouble, int paramInt)
  {
    Object localObject = this.mT;
    int k = localObject.length;
    int j = 0;
    double d1;
    if (paramDouble < localObject[0])
    {
      d1 = localObject[0];
      i = j;
    }
    else
    {
      int m = k - 1;
      i = j;
      d1 = paramDouble;
      if (paramDouble >= localObject[m]) {
        d1 = localObject[m];
      }
    }
    for (int i = j; i < k - 1; i = j)
    {
      localObject = this.mT;
      j = i + 1;
      if (d1 <= localObject[j])
      {
        paramDouble = localObject[j];
        d1 = localObject[i];
        double d2 = localObject[i];
        localObject = this.mY;
        d2 = localObject[i][paramInt];
        return (localObject[j][paramInt] - d2) / (paramDouble - d1);
      }
    }
    return 0.0D;
  }
  
  public void getSlope(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.mT;
    int n = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int j = 0;
    int m = arrayOfDouble[0].length;
    double d1;
    if (paramDouble <= localObject[0])
    {
      d1 = localObject[0];
    }
    else
    {
      i = n - 1;
      d1 = paramDouble;
      if (paramDouble >= localObject[i]) {
        d1 = localObject[i];
      }
    }
    int k;
    for (int i = 0; i < n - 1; i = k)
    {
      localObject = this.mT;
      k = i + 1;
      if (d1 <= localObject[k])
      {
        paramDouble = localObject[k];
        d1 = localObject[i];
        double d2 = localObject[i];
        while (j < m)
        {
          localObject = this.mY;
          d2 = localObject[i][j];
          paramArrayOfDouble[j] = ((localObject[k][j] - d2) / (paramDouble - d1));
          j += 1;
        }
      }
    }
  }
  
  public double[] getTimePoints()
  {
    return this.mT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.LinearCurveFit
 * JD-Core Version:    0.7.0.1
 */