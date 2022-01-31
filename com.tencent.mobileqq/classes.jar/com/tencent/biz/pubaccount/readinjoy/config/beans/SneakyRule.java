package com.tencent.biz.pubaccount.readinjoy.config.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SneakyRule
  implements AladdinConfigBean
{
  private boolean enable;
  private Set<String> fingerprintSet = new HashSet();
  private List<String> props = new ArrayList();
  
  public Set<String> getFingerprintSet()
  {
    return this.fingerprintSet;
  }
  
  public List<String> getProps()
  {
    return this.props;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public String toString()
  {
    return "SneakyRule{props=" + this.props + ", fingerprintSet=" + this.fingerprintSet + ", enable=" + this.enable + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyRule
 * JD-Core Version:    0.7.0.1
 */