package androidx.constraintlayout.solver.state;

import java.util.ArrayList;

class ConstraintReference$IncorrectConstraintException
  extends Exception
{
  private final ArrayList<String> mErrors;
  
  public ConstraintReference$IncorrectConstraintException(ArrayList<String> paramArrayList)
  {
    Object localObject;
    this.mErrors = localObject;
  }
  
  public ArrayList<String> getErrors()
  {
    return this.mErrors;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IncorrectConstraintException: ");
    localStringBuilder.append(this.mErrors.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.ConstraintReference.IncorrectConstraintException
 * JD-Core Version:    0.7.0.1
 */