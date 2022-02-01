package androidx.constraintlayout.motion.utils;

class ArcCurveFit
  extends CurveFit
{
  public static final int ARC_START_FLIP = 3;
  public static final int ARC_START_HORIZONTAL = 2;
  public static final int ARC_START_LINEAR = 0;
  public static final int ARC_START_VERTICAL = 1;
  private static final int START_HORIZONTAL = 2;
  private static final int START_LINEAR = 3;
  private static final int START_VERTICAL = 1;
  ArcCurveFit.Arc[] mArcs;
  private final double[] mTime;
  
  public ArcCurveFit(int[] paramArrayOfInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    this.mTime = paramArrayOfDouble;
    this.mArcs = new ArcCurveFit.Arc[paramArrayOfDouble.length - 1];
    int k = 0;
    int j = 1;
    int i = 1;
    while (k < this.mArcs.length)
    {
      int n = paramArrayOfInt[k];
      int m = 2;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3)
            {
              if (j == 1) {
                i = m;
              } else {
                i = 1;
              }
              j = i;
            }
          }
          else
          {
            j = 2;
            i = m;
          }
        }
        else
        {
          j = 1;
          i = 1;
        }
      }
      else {
        i = 3;
      }
      ArcCurveFit.Arc[] arrayOfArc = this.mArcs;
      double d = paramArrayOfDouble[k];
      m = k + 1;
      arrayOfArc[k] = new ArcCurveFit.Arc(i, d, paramArrayOfDouble[m], paramArrayOfDouble1[k][0], paramArrayOfDouble1[k][1], paramArrayOfDouble1[m][0], paramArrayOfDouble1[m][1]);
      k = m;
    }
  }
  
  public double getPos(double paramDouble, int paramInt)
  {
    ArcCurveFit.Arc[] arrayOfArc = this.mArcs;
    int j = 0;
    double d;
    int i;
    if (paramDouble < arrayOfArc[0].mTime1)
    {
      d = this.mArcs[0].mTime1;
      i = j;
    }
    else
    {
      arrayOfArc = this.mArcs;
      i = j;
      d = paramDouble;
      if (paramDouble > arrayOfArc[(arrayOfArc.length - 1)].mTime2)
      {
        arrayOfArc = this.mArcs;
        d = arrayOfArc[(arrayOfArc.length - 1)].mTime2;
        i = j;
      }
    }
    for (;;)
    {
      arrayOfArc = this.mArcs;
      if (i >= arrayOfArc.length) {
        break;
      }
      if (d <= arrayOfArc[i].mTime2)
      {
        if (this.mArcs[i].linear)
        {
          if (paramInt == 0) {
            return this.mArcs[i].getLinearX(d);
          }
          return this.mArcs[i].getLinearY(d);
        }
        this.mArcs[i].setPoint(d);
        if (paramInt == 0) {
          return this.mArcs[i].getX();
        }
        return this.mArcs[i].getY();
      }
      i += 1;
    }
    return (0.0D / 0.0D);
  }
  
  public void getPos(double paramDouble, double[] paramArrayOfDouble)
  {
    double d = paramDouble;
    if (paramDouble < this.mArcs[0].mTime1) {
      d = this.mArcs[0].mTime1;
    }
    ArcCurveFit.Arc[] arrayOfArc = this.mArcs;
    paramDouble = d;
    if (d > arrayOfArc[(arrayOfArc.length - 1)].mTime2)
    {
      arrayOfArc = this.mArcs;
      paramDouble = arrayOfArc[(arrayOfArc.length - 1)].mTime2;
    }
    int i = 0;
    for (;;)
    {
      arrayOfArc = this.mArcs;
      if (i >= arrayOfArc.length) {
        break;
      }
      if (paramDouble <= arrayOfArc[i].mTime2)
      {
        if (this.mArcs[i].linear)
        {
          paramArrayOfDouble[0] = this.mArcs[i].getLinearX(paramDouble);
          paramArrayOfDouble[1] = this.mArcs[i].getLinearY(paramDouble);
          return;
        }
        this.mArcs[i].setPoint(paramDouble);
        paramArrayOfDouble[0] = this.mArcs[i].getX();
        paramArrayOfDouble[1] = this.mArcs[i].getY();
        return;
      }
      i += 1;
    }
  }
  
  public void getPos(double paramDouble, float[] paramArrayOfFloat)
  {
    double d;
    ArcCurveFit.Arc[] arrayOfArc;
    if (paramDouble < this.mArcs[0].mTime1)
    {
      d = this.mArcs[0].mTime1;
    }
    else
    {
      arrayOfArc = this.mArcs;
      d = paramDouble;
      if (paramDouble > arrayOfArc[(arrayOfArc.length - 1)].mTime2)
      {
        arrayOfArc = this.mArcs;
        d = arrayOfArc[(arrayOfArc.length - 1)].mTime2;
      }
    }
    int i = 0;
    for (;;)
    {
      arrayOfArc = this.mArcs;
      if (i >= arrayOfArc.length) {
        break;
      }
      if (d <= arrayOfArc[i].mTime2)
      {
        if (this.mArcs[i].linear)
        {
          paramArrayOfFloat[0] = ((float)this.mArcs[i].getLinearX(d));
          paramArrayOfFloat[1] = ((float)this.mArcs[i].getLinearY(d));
          return;
        }
        this.mArcs[i].setPoint(d);
        paramArrayOfFloat[0] = ((float)this.mArcs[i].getX());
        paramArrayOfFloat[1] = ((float)this.mArcs[i].getY());
        return;
      }
      i += 1;
    }
  }
  
  public double getSlope(double paramDouble, int paramInt)
  {
    ArcCurveFit.Arc[] arrayOfArc = this.mArcs;
    int j = 0;
    double d = paramDouble;
    if (paramDouble < arrayOfArc[0].mTime1) {
      d = this.mArcs[0].mTime1;
    }
    arrayOfArc = this.mArcs;
    int i = j;
    paramDouble = d;
    if (d > arrayOfArc[(arrayOfArc.length - 1)].mTime2)
    {
      arrayOfArc = this.mArcs;
      paramDouble = arrayOfArc[(arrayOfArc.length - 1)].mTime2;
      i = j;
    }
    for (;;)
    {
      arrayOfArc = this.mArcs;
      if (i >= arrayOfArc.length) {
        break;
      }
      if (paramDouble <= arrayOfArc[i].mTime2)
      {
        if (this.mArcs[i].linear)
        {
          if (paramInt == 0) {
            return this.mArcs[i].getLinearDX(paramDouble);
          }
          return this.mArcs[i].getLinearDY(paramDouble);
        }
        this.mArcs[i].setPoint(paramDouble);
        if (paramInt == 0) {
          return this.mArcs[i].getDX();
        }
        return this.mArcs[i].getDY();
      }
      i += 1;
    }
    return (0.0D / 0.0D);
  }
  
  public void getSlope(double paramDouble, double[] paramArrayOfDouble)
  {
    double d;
    ArcCurveFit.Arc[] arrayOfArc;
    if (paramDouble < this.mArcs[0].mTime1)
    {
      d = this.mArcs[0].mTime1;
    }
    else
    {
      arrayOfArc = this.mArcs;
      d = paramDouble;
      if (paramDouble > arrayOfArc[(arrayOfArc.length - 1)].mTime2)
      {
        arrayOfArc = this.mArcs;
        d = arrayOfArc[(arrayOfArc.length - 1)].mTime2;
      }
    }
    int i = 0;
    for (;;)
    {
      arrayOfArc = this.mArcs;
      if (i >= arrayOfArc.length) {
        break;
      }
      if (d <= arrayOfArc[i].mTime2)
      {
        if (this.mArcs[i].linear)
        {
          paramArrayOfDouble[0] = this.mArcs[i].getLinearDX(d);
          paramArrayOfDouble[1] = this.mArcs[i].getLinearDY(d);
          return;
        }
        this.mArcs[i].setPoint(d);
        paramArrayOfDouble[0] = this.mArcs[i].getDX();
        paramArrayOfDouble[1] = this.mArcs[i].getDY();
        return;
      }
      i += 1;
    }
  }
  
  public double[] getTimePoints()
  {
    return this.mTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.ArcCurveFit
 * JD-Core Version:    0.7.0.1
 */