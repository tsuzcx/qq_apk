package android.support.v7.widget;

class AdapterHelper$UpdateOp
{
  static final int ADD = 1;
  static final int MOVE = 8;
  static final int POOL_SIZE = 30;
  static final int REMOVE = 2;
  static final int UPDATE = 4;
  int cmd;
  int itemCount;
  Object payload;
  int positionStart;
  
  AdapterHelper$UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.cmd = paramInt1;
    this.positionStart = paramInt2;
    this.itemCount = paramInt3;
    this.payload = paramObject;
  }
  
  String cmdToString()
  {
    int i = this.cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 8) {
            return "??";
          }
          return "mv";
        }
        return "up";
      }
      return "rm";
    }
    return "add";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (UpdateOp)paramObject;
      int i = this.cmd;
      if (i != paramObject.cmd) {
        return false;
      }
      if ((i == 8) && (Math.abs(this.itemCount - this.positionStart) == 1) && (this.itemCount == paramObject.positionStart) && (this.positionStart == paramObject.itemCount)) {
        return true;
      }
      if (this.itemCount != paramObject.itemCount) {
        return false;
      }
      if (this.positionStart != paramObject.positionStart) {
        return false;
      }
      Object localObject = this.payload;
      if (localObject != null)
      {
        if (!localObject.equals(paramObject.payload)) {
          return false;
        }
      }
      else if (paramObject.payload != null) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("[");
    localStringBuilder.append(cmdToString());
    localStringBuilder.append(",s:");
    localStringBuilder.append(this.positionStart);
    localStringBuilder.append("c:");
    localStringBuilder.append(this.itemCount);
    localStringBuilder.append(",p:");
    localStringBuilder.append(this.payload);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper.UpdateOp
 * JD-Core Version:    0.7.0.1
 */